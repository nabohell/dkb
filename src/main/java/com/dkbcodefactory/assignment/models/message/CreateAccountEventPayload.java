package com.dkbcodefactory.assignment.models.message;

import com.dkbcodefactory.assignment.models.AccountType;
import com.dkbcodefactory.assignment.models.Client;

public class CreateAccountEventPayload {

    private Client client;
    private AccountType accountType;

    public CreateAccountEventPayload(Client client, AccountType accountType) {
        this.client = client;
        this.accountType = accountType;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
