package com.project.javaapifinance.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import com.project.javaapifinance.builder.AccountCreator;
import com.project.javaapifinance.domain.Account;
import com.project.javaapifinance.enums.AccountTypeEnum;
import com.project.javaapifinance.service.AccountService;
import com.project.javaapifinance.utils.JsonUtils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = AccountController.class)
public class AccountControllerTests {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService service;

    @Test
    public void mustReturn200WhenGetAccountList() throws Exception {
        this.mockMvc.perform(get("/account/")).andExpect(status().isOk());
    }

    @Test
    public void mustReturn200WhenGetAccountById() throws Exception {
        this.mockMvc.perform(get("/account/1")).andExpect(status().isOk());
    }

    @Test
    public void mustReturn204WhenDeleteAccount() throws Exception {
        this.mockMvc.perform(delete("/account/1")).andExpect(status().isNoContent());
    }

    @Test
    public void mustReturn200WhenUpdateAccount() throws Exception {
        Account account = new AccountCreator()
            .id(1l)
            .accountNumber(7880l)
            .blocked(false)
            .accountType(AccountTypeEnum.CURRENT_ACCOUNT)
            .creationDate(LocalDate.of(2021, 1, 8))
            .build();
        
        String body = JsonUtils.jsonString(account);

        this.mockMvc.perform(put("/account/").content(body)).andExpect(status().isOk());
    }

    @Test
    public void mustReturn201WhenCreateAccount() throws Exception {
        Account account = new AccountCreator().createAccountWithoutId();
        String body = JsonUtils.jsonString(account);
        
        this.mockMvc.perform(
            post("/account/")
            .content(body)
            .contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isCreated());
    }
}