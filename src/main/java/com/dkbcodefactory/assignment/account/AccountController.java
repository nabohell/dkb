package com.dkbcodefactory.assignment.account;

import com.dkbcodefactory.assignment.client.ClientService;
import com.dkbcodefactory.assignment.errors.InvalidRequestException;
import com.dkbcodefactory.assignment.errors.NotFoundException;
import com.dkbcodefactory.assignment.events.MoneyDepositEvent;
import com.dkbcodefactory.assignment.events.MoneyTransferEvent;
import com.dkbcodefactory.assignment.models.Account;
import com.dkbcodefactory.assignment.models.message.*;
import com.dkbcodefactory.assignment.server.IbanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("accounts")
public class AccountController {

    @Autowired
    AccountService service;

    @Autowired
    ApplicationEventPublisher publisher;

    @PostMapping()
    public ResponseEntity accountsAction(@RequestBody AccountActionRequest request) {
        if (request.getAction() == null) {
            throw  new InvalidRequestException("Action can't be empty");
        }

        if (request.getIban() == null) {
            throw  new InvalidRequestException("Iban can't be empty");
        }

        IbanUtil.verifyIban(request.getIban());

        Account account = this.service.findAccountByIban(request.getIban());
        if(account == null) {
            throw new NotFoundException("Iban not found [" + request.getIban() + "]");
        }

        if(!account.getActive()) {
            throw new NotFoundException("Iban is locked [" + request.getIban() + "]");
        }

        if (AccountAction.BALANCE == request.getAction()) {
            return ResponseEntity.ok(new AccountBalanceResponse(account.getBalance()));
        }

        Double amount = request.getAmount();
        if (!(amount > 0)) {
            throw new InvalidRequestException("Invalid amount value");
        }

        if (AccountAction.DEPOSIT == request.getAction()) {
            this.publisher.publishEvent(
                    new MoneyDepositEvent(
                            new MoneyDepositEventPayload(account, new Date(), amount)));

            return ResponseEntity.ok().build();
        }

        if (AccountAction.TRANSFER == request.getAction()) {
            if (request.getTargetIban() == null) {
                throw  new InvalidRequestException("TargetIban can't be empty");
            }

            IbanUtil.verifyIban(request.getTargetIban());

            Account to = this.service.findAccountByIban(request.getTargetIban());
            if (to == null) {
                throw new NotFoundException("Iban not found [" + request.getTargetIban() + "]");
            }

            if (!to.getActive()) {
                throw new NotFoundException("Iban is locked [" + request.getTargetIban() + "]");
            }

            this.publisher.publishEvent(
                    new MoneyTransferEvent(
                            new MoneyTransferEventPayload(account, to, new Date(), amount)));

            return ResponseEntity.ok().build();
        }

        throw new InvalidRequestException();
    }

    @GetMapping()
    public ResponseEntity search(
            @RequestParam("type") String accountTypeName,
            @RequestParam(value = "iban", required = false, defaultValue = "") String iban,
            Pageable pageable) {
        return ResponseEntity.ok(this.service.findByAccountType(accountTypeName, iban, pageable));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@RequestBody AccountUpdateRequest accountUpdateRequest, @PathVariable("id") Long accountId) {
        Account account = this.service.findAccountById(accountId)
                .orElseThrow(()-> new NotFoundException("Account not found [" +accountId + "]"));

        switch (accountUpdateRequest.getAction()) {
            case LOCK:
                this.service.lockAccount(account);
                break;
            case UNLOCK:
                this.service.unlockAccount(account);
                break;
            default:
                throw new InvalidRequestException();
        }

        return ResponseEntity.ok().build();
    }
}
