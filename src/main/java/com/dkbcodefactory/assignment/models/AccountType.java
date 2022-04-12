package com.dkbcodefactory.assignment.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class AccountType extends AbstractModel{

    @Column(unique = true)
    private String name;

    @OneToOne
    private AccountTypeSettings settings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AccountTypeSettings getSettings() {
        return settings;
    }

    public void setSettings(AccountTypeSettings settings) {
        this.settings = settings;
    }
}
