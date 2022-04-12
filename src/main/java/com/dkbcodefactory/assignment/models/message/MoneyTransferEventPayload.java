package com.dkbcodefactory.assignment.models.message;

import com.dkbcodefactory.assignment.models.Account;

import java.util.Date;

public class MoneyTransferEventPayload {
    private Account from;
    private Account to;
    private Date date;
    private Double amount;

    public MoneyTransferEventPayload(Account from, Account to, Date date, Double amount) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Account getFrom() {
        return from;
    }

    public void setFrom(Account from) {
        this.from = from;
    }

    public Account getTo() {
        return to;
    }

    public void setTo(Account to) {
        this.to = to;
    }
}
