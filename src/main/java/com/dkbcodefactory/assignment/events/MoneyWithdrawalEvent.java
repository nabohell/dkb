package com.dkbcodefactory.assignment.events;

import com.dkbcodefactory.assignment.models.message.MoneyTransferEventPayload;
import com.dkbcodefactory.assignment.models.message.MoneyWithdrawalEventPayload;
import org.springframework.context.ApplicationEvent;

public class MoneyWithdrawalEvent extends ApplicationEvent {
    public MoneyWithdrawalEvent(MoneyWithdrawalEventPayload source) {
        super(source);
    }

    @Override
    public MoneyWithdrawalEventPayload getSource() {
        return (MoneyWithdrawalEventPayload) super.getSource();
    }
}
