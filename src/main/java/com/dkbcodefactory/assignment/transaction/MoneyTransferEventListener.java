package com.dkbcodefactory.assignment.transaction;

import com.dkbcodefactory.assignment.events.MoneyTransferEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MoneyTransferEventListener implements ApplicationListener<MoneyTransferEvent> {
    @Autowired
    TransactionProcessorService transactionProcessorService;

    @Override
    public void onApplicationEvent(MoneyTransferEvent event) {
    this.transactionProcessorService.processTransferTransactions(
            event.getSource().getFrom(),
            event.getSource().getTo(),
            event.getSource().getAmount(),
            event.getSource().getDate());
    }
}
