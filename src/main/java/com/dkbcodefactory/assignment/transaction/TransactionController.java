package com.dkbcodefactory.assignment.transaction;

import com.dkbcodefactory.assignment.models.message.TransactionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping()
    public ResponseEntity getHistory(@RequestParam("iban") String iban, Pageable pageable) {
        return ResponseEntity.ok(this.transactionService.getTransactionsHistory(iban, pageable));
    }
}
