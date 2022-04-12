package com.dkbcodefactory.assignment.transaction;

import com.dkbcodefactory.assignment.models.Account;
import com.dkbcodefactory.assignment.models.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {

    Page<Transaction> findByAccount_Iban(String iban, Pageable pageable);
}
