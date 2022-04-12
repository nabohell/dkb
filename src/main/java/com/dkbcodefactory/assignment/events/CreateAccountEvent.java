package com.dkbcodefactory.assignment.events;

import com.dkbcodefactory.assignment.models.message.CreateAccountEventPayload;
import org.springframework.context.ApplicationEvent;

public class CreateAccountEvent extends ApplicationEvent {
    public CreateAccountEvent(CreateAccountEventPayload source) {
        super(source);
    }

    @Override
    public CreateAccountEventPayload getSource() {
        return (CreateAccountEventPayload) super.getSource();
    }
}
