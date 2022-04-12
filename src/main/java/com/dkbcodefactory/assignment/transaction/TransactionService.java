package com.dkbcodefactory.assignment.transaction;

import com.dkbcodefactory.assignment.models.Transaction;
import com.dkbcodefactory.assignment.models.message.TransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.Converter;

@Service
public class TransactionService {

    @Autowired
    TransactionRepo transactionRepo;

    public Transaction save(Transaction transaction) {
        return this.transactionRepo.saveAndFlush(transaction);
    }

    public Page getTransactionsHistory(String iban, Pageable pageable) {
        return this.transactionRepo.findByAccount_Iban(iban, pageable).map(TransactionDTO::fromEntity);
    }
}
