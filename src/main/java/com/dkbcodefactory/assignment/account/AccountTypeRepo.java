package com.dkbcodefactory.assignment.account;

import com.dkbcodefactory.assignment.models.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTypeRepo extends JpaRepository<AccountType, Long> {
    AccountType findByName(String name);
}
