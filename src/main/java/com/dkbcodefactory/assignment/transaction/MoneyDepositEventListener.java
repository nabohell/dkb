package com.dkbcodefactory.assignment.transaction;

import com.dkbcodefactory.assignment.events.MoneyDepositEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MoneyDepositEventListener implements ApplicationListener<MoneyDepositEvent> {
    @Autowired
    TransactionProcessorService transactionProcessorService;

    @Override
    public void onApplicationEvent(MoneyDepositEvent event) {
        this.transactionProcessorService.processDepositTransaction(
                event.getSource().getAccount(),
                event.getSource().getAmount(),
                event.getSource().getDate());
    }
}
