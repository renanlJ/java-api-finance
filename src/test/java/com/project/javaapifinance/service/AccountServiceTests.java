package com.project.javaapifinance.service;

import com.project.javaapifinance.builder.AccountCreator;
import com.project.javaapifinance.domain.Account;
import com.project.javaapifinance.repository.AccountRepository;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AccountServiceTests {
    
    @InjectMocks
    private AccountService accountService;

    @Mock
    private AccountRepository accountRepository;

    @Test
    public void mustRegisterAnAccount() {
        Account account = new AccountCreator().createAccountWithoutId();
        given(accountRepository.save(account)).willReturn(account);

        assertThat(accountService.createAccount(account), equalTo(account));
    }

    @Test
    public void mustUpdateAnAccount() {
        Account account = new AccountCreator().createAccountWithId();
        given(accountRepository.save(account)).willReturn(account);

        assertThat(accountService.updateAccount(account), equalTo(account));
    }

    @Test
    public void mustReturnAnAccountById(){
        Account account = new AccountCreator().createAccountWithId();
        given(accountRepository.getOne(account.getId())).willReturn(account);

        assertThat(accountService.getAccountById(account.getId()), equalTo(account));
    }

    @Test
    public void mustDeleteAnAccount(){
        Account account = new AccountCreator().createAccountWithId();
        given(accountRepository.getOne(account.getId())).willReturn(account);
        accountService.deleteAccount(account.getId());
        
        verify(accountRepository, times(1)).deleteById(account.getId());
    }

    @Test
    public void mustFindAllAccounts() {
        List<Account> accounts = new AccountCreator().createAccountsWithId();
        given(accountRepository.findAll()).willReturn(accounts);

        assertThat(accountService.findAllAccounts(), equalTo(accounts));
    }

}