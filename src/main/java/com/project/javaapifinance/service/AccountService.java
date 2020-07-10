package com.project.javaapifinance.service;

import com.project.javaapifinance.domain.Account;
import com.project.javaapifinance.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

	public Account updateAccount(Account account) {
		return accountRepository.save(account);
	}

	public Account getAccountById(Long id) {
		return accountRepository.getOne(id);
	}

	public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
	}

}