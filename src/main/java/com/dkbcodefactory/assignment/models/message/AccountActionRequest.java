package com.dkbcodefactory.assignment.models.message;

public class AccountActionRequest {

    private AccountAction action;
    private String iban;
    private String targetIban;
    private Double amount;

    public void setAction(AccountAction action) {
        this.action = action;
    }

    public AccountAction getAction() {
        return action;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setTargetIban(String targetIban) {
        this.targetIban = targetIban;
    }

    public String getTargetIban() {
        return targetIban;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }
}
