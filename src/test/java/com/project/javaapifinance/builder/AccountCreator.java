package com.project.javaapifinance.builder;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import com.project.javaapifinance.domain.Account;
import com.project.javaapifinance.enums.AccountTypeEnum;

public class AccountCreator {

    private Account account;

    public AccountCreator() {
        this.account = new Account();
    }

    public AccountCreator id(Long id) {
        this.account.setId(id);
        return this;
    }

    public AccountCreator accountNumber(Long number) {
        this.account.setNumber(number);
        return this;
    }

    public AccountCreator blocked(boolean enable) {
        this.account.setBlocked(enable);
        return this;
    }

    public AccountCreator accountType(AccountTypeEnum type) {
        this.account.setType(type);
        return this;
    }

    public AccountCreator creationDate(LocalDate date) {
        this.account.setCreationDate(date);
        return this;
    }

    public Account build() {
        return this.account;
    }

    public Account createAccountWithId() {
        return new AccountCreator()
            .id(Long.valueOf(new Random().nextLong()))
            .accountNumber(Long.valueOf(new Random().nextLong()))
            .accountType(AccountTypeEnum.CURRENT_ACCOUNT)
            .creationDate(LocalDate.of(2000, 12, 01))
            .build();
    }

    public List<Account> createAccountsWithId() {
        Account account1 = createAccountWithId();
        Account account2 = createAccountWithId();

        return List.of(account1, account2);
    }

    public Account createAccountWithoutId() {
        return new AccountCreator()
            .accountNumber(Long.valueOf(new Random().nextLong()))
            .accountType(AccountTypeEnum.CURRENT_ACCOUNT)
            .creationDate(LocalDate.of(2000, 12, 01))
            .build();
    }
    
}