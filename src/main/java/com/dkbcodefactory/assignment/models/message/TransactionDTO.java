package com.dkbcodefactory.assignment.models.message;

import com.dkbcodefactory.assignment.models.Account;
import com.dkbcodefactory.assignment.models.Transaction;
import com.dkbcodefactory.assignment.models.TransactionType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

public class TransactionDTO {

    private String iban;
    private Double amount;
    private Date date;
    private TransactionType transactionType;

    public TransactionDTO(Transaction transaction) {
        this.iban = transaction.getAccount().getIban();
        this.amount = transaction.getAmount();
        this.date = transaction.getDate();
        this.transactionType = transaction.getTransactionType();
    }

    public static TransactionDTO fromEntity(Transaction o) {
        return new TransactionDTO(o);
    }


    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}
