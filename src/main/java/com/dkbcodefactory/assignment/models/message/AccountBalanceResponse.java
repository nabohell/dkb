package com.dkbcodefactory.assignment.models.message;

public class AccountBalanceResponse {
    private Double balance;

    public AccountBalanceResponse(Double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
