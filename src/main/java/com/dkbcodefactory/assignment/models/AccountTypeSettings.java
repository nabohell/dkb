package com.dkbcodefactory.assignment.models;

import javax.persistence.Entity;

@Entity
public class AccountTypeSettings extends AbstractModel {
    private boolean withdraw;
    private boolean deposit;

    public boolean isWithdraw() {
        return withdraw;
    }

    public void setWithdraw(boolean withdraw) {
        this.withdraw = withdraw;
    }

    public boolean isDeposit() {
        return deposit;
    }

    public void setDeposit(boolean deposit) {
        this.deposit = deposit;
    }
}
