package com.dkbcodefactory.assignment.events;

import com.dkbcodefactory.assignment.models.message.MoneyTransferEventPayload;
import org.springframework.context.ApplicationEvent;

public class MoneyTransferEvent extends ApplicationEvent {
    public MoneyTransferEvent(MoneyTransferEventPayload source) {
        super(source);
    }

    @Override
    public MoneyTransferEventPayload getSource() {
        return (MoneyTransferEventPayload) super.getSource();
    }
}
