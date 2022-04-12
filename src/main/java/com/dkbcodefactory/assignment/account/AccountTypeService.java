package com.dkbcodefactory.assignment.account;

import com.dkbcodefactory.assignment.models.AccountType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountTypeService {

    @Autowired
    private AccountTypeRepo accountTypeRepo;

    public AccountType getAccountTypeByName(String accountTypeName) {
        return this.accountTypeRepo.findByName(accountTypeName);
    }
}
