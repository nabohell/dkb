package com.dkbcodefactory.assignment.account;

import com.dkbcodefactory.assignment.events.AccountBalanceUpdatedEvent;
import com.dkbcodefactory.assignment.models.Account;
import com.dkbcodefactory.assignment.models.Transaction;
import com.dkbcodefactory.assignment.models.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AccountUpdatedEventListener implements ApplicationListener<AccountBalanceUpdatedEvent> {

    @Autowired
    AccountService service;

    @Override
    public void onApplicationEvent(AccountBalanceUpdatedEvent event) {
        Transaction transaction = event.getSource();
        Account account = transaction.getAccount();
        final Double amount = transaction.getAmount() * (TransactionType.DEPT == transaction.getTransactionType() ? -1: 1);
        account.setBalance(account.getBalance() + amount);
        this.service.save(account);
    }
}
