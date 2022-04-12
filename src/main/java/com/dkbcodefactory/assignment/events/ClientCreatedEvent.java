package com.dkbcodefactory.assignment.events;

import com.dkbcodefactory.assignment.models.Client;
import org.springframework.context.ApplicationEvent;

public class ClientCreatedEvent extends ApplicationEvent {

    public ClientCreatedEvent(Client client) {
        super(client);
    }

    @Override
    public Client getSource() {
        return (Client) super.getSource();
    }
}
