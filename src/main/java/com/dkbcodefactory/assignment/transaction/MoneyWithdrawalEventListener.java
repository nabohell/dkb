package com.dkbcodefactory.assignment.transaction;

import com.dkbcodefactory.assignment.events.MoneyWithdrawalEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MoneyWithdrawalEventListener implements ApplicationListener<MoneyWithdrawalEvent> {
    @Autowired
    TransactionProcessorService transactionProcessorService;

    @Override
    public void onApplicationEvent(MoneyWithdrawalEvent event) {
        this.transactionProcessorService.processWithdrawTransaction(
                event.getSource().getAccount(),
                event.getSource().getAmount(),
                event.getSource().getDate());
    }
}
