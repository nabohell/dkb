package com.dkbcodefactory.assignment.account;

import com.dkbcodefactory.assignment.models.Account;
import com.dkbcodefactory.assignment.models.AccountType;
import com.dkbcodefactory.assignment.models.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {
    Integer countAccountByClient(Client client);
    Page findAccountByClient(Client client, Pageable pageable);
    Page<Account> findAccountByType_NameAndIbanContaining(String accountTypeName, String iban, Pageable pageable);
    Account findByIbanEquals(String iban);
}