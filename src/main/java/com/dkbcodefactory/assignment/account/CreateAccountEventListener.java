package com.dkbcodefactory.assignment.account;

import com.dkbcodefactory.assignment.events.CreateAccountEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class CreateAccountEventListener implements ApplicationListener<CreateAccountEvent> {

    @Autowired
    AccountService accountService;
    @Override
    public void onApplicationEvent(CreateAccountEvent event) {
        this.accountService.createAccount(event.getSource().getClient(), event.getSource().getAccountType());
    }
}
