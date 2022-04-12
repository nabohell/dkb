package com.dkbcodefactory.assignment.models.message;

import java.util.Map;

public class AccountUpdateRequest {

    private UpdateAction action;

    public UpdateAction getAction() {
        return action;
    }

    public void setAction(UpdateAction action) {
        this.action = action;
    }
}
