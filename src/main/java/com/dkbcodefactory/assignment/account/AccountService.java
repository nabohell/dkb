package com.dkbcodefactory.assignment.account;

import com.dkbcodefactory.assignment.models.Account;
import com.dkbcodefactory.assignment.models.AccountType;
import com.dkbcodefactory.assignment.models.Client;
import com.dkbcodefactory.assignment.models.message.AccountDTO;
import com.dkbcodefactory.assignment.server.IbanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    private static final String DEFAULT_CURRENCY = "eur";
    private static final String BANK_CODE = "00001111";
    private static final String DEFAULT_BRANCH = "0001";

    @Autowired AccountRepo accountRepo;

    public Page findByAccountType(String accountTypeName, String iban, Pageable pageable) {
        return accountRepo.findAccountByType_NameAndIbanContaining(accountTypeName, iban, pageable).map(AccountDTO::fromEntity);
    }

    public void createDefaultAccount(Client client) {
        AccountType defaultType = new AccountType();
        this.createAccount(client, defaultType);
    }

    public Account createAccount(Client client, AccountType accountType) {
        Integer totalAccountCount = this.getClientAccountCount(client);
        Account account = new Account();
        account.setCurrency(DEFAULT_CURRENCY);
        account.setType(accountType);
        account.setBalance(0.0);
        account.setIban(generateIban(client, ++totalAccountCount));
        account.setClient(client);
        account.setActive(true);
        return this.accountRepo.saveAndFlush(account);
    }

    private String generateIban(Client client, Integer count) {
        String accountNumber = IbanUtil.generate10DigitAccountNumber(client.getId(), count);
        return IbanUtil.generateIbanNumber(accountNumber, BANK_CODE, DEFAULT_BRANCH);
    }

    public void save(Account account) {
        this.accountRepo.saveAndFlush(account);
    }

    public Account findAccountByIban(String iban) {
        return this.accountRepo.findByIbanEquals(iban);
    }

    public Optional<Account> findAccountById(Long accountId) {
        return this.accountRepo.findById(accountId);
    }

    public void lockAccount(Account account) {
        account.setActive(false);
        this.accountRepo.saveAndFlush(account);
    }

    public void unlockAccount(Account account) {
        account.setActive(true);
        this.accountRepo.saveAndFlush(account);
    }

    public Integer getClientAccountCount(Client client) {
        return this.accountRepo.countAccountByClient(client);
    }
}
