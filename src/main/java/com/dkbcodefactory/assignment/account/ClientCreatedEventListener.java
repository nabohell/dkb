package com.dkbcodefactory.assignment.account;

import com.dkbcodefactory.assignment.events.ClientCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ClientCreatedEventListener implements ApplicationListener<ClientCreatedEvent> {

    @Autowired
    AccountService service;

    @Override
    public void onApplicationEvent(ClientCreatedEvent event) {
        this.service.createDefaultAccount(event.getSource());
    }
}
