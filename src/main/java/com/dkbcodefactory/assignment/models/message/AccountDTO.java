package com.dkbcodefactory.assignment.models.message;

import com.dkbcodefactory.assignment.models.Account;

public class AccountDTO {
    private String accountType;
    private Long clientNo;
    private String clientName;
    private String iban;
    private String currency;
    private Double balance;
    private Boolean active;

    public static AccountDTO fromEntity(Account account){
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountType(account.getType().getName());
        accountDTO.setClientName(new StringBuffer().append(
                account.getClient().getFirstName())
                .append(' ')
                .append(account.getClient().getMiddleName())
                .append(' ')
                .append(account.getClient().getLastName())
                .toString());
        accountDTO.setIban(account.getIban());
        accountDTO.setActive(account.getActive());
        accountDTO.setBalance(account.getBalance());
        accountDTO.setClientNo(account.getId());
        accountDTO.setCurrency(account.getCurrency());
        return accountDTO;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Long getClientNo() {
        return clientNo;
    }

    public void setClientNo(Long clientNo) {
        this.clientNo = clientNo;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
