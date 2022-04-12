package com.dkbcodefactory.assignment.transaction;

import com.dkbcodefactory.assignment.events.AccountBalanceUpdatedEvent;
import com.dkbcodefactory.assignment.models.Account;
import com.dkbcodefactory.assignment.models.Transaction;
import com.dkbcodefactory.assignment.models.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class TransactionProcessorService {

    @Autowired
    TransactionService transactionService;

    @Autowired
    ApplicationEventPublisher publisher;

    public void processDepositTransaction(Account account, Double amount, Date date) {
        Transaction transaction =  createTransaction(account, amount, date, TransactionType.CREDIT);
        this.publisher.publishEvent( new AccountBalanceUpdatedEvent( transaction));
    }

    public void processWithdrawTransaction(Account account, Double amount, Date date) {
        Transaction transaction = createTransaction(account, amount, date, TransactionType.DEPT);
        this.publisher.publishEvent( new AccountBalanceUpdatedEvent( transaction));
    }

    @Transactional
    public void processTransferTransactions(Account from, Account to, Double amount, Date date) {
        Transaction transaction1 =  createTransaction(from, amount, date, TransactionType.DEPT);
        Transaction transaction2 =  createTransaction(to, amount, date, TransactionType.CREDIT);

        // notify for balance change to update the aggregated balance value in each account
        this.publisher.publishEvent( new AccountBalanceUpdatedEvent( transaction1));
        this.publisher.publishEvent( new AccountBalanceUpdatedEvent( transaction2));
    }

    private  Transaction createTransaction(Account account, Double amount, Date date, TransactionType type) {
        Transaction transaction = new Transaction();
        transaction.setTransactionType(type);
        transaction.setAmount(amount);
        transaction.setDate(date);
        transaction.setAccount(account);
        return this.transactionService.save(transaction);
    }
}
