package com.dkbcodefactory.assignment.events;

import com.dkbcodefactory.assignment.models.message.MoneyDepositEventPayload;
import org.springframework.context.ApplicationEvent;

public class MoneyDepositEvent extends ApplicationEvent {
    public MoneyDepositEvent(MoneyDepositEventPayload source) {
        super(source);
    }

    @Override
    public MoneyDepositEventPayload getSource() {
        return (MoneyDepositEventPayload) super.getSource();
    }
}
