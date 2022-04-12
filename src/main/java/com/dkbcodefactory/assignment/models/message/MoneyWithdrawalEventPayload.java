package com.dkbcodefactory.assignment.models.message;

import com.dkbcodefactory.assignment.models.Account;

import java.util.Date;

public class MoneyWithdrawalEventPayload {
    private Account account;
    private Date date;
    private Double amount;

    public MoneyWithdrawalEventPayload(Account account, Date date, Double amount) {
        this.account = account;
        this.date = date;
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
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
}
