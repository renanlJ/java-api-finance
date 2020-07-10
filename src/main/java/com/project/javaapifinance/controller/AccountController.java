package com.project.javaapifinance.controller;

import java.util.Arrays;
import java.util.List;

import com.project.javaapifinance.domain.Account;
import com.project.javaapifinance.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;
    
    @GetMapping("/")
    @ResponseBody
    public Account getAccounts() {
        return accountService.getAccountById(1l);
    }
    

}