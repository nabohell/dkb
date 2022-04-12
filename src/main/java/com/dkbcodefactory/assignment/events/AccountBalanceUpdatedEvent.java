package com.dkbcodefactory.assignment.events;

import com.dkbcodefactory.assignment.models.Transaction;
import org.springframework.context.ApplicationEvent;

public class AccountBalanceUpdatedEvent extends ApplicationEvent {
    public AccountBalanceUpdatedEvent(Transaction source) {
        super(source);
    }

    @Override
    public Transaction getSource() {
        return (Transaction) super.getSource();
    }
}
