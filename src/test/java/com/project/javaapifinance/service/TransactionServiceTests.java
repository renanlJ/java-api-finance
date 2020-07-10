package com.project.javaapifinance.service;

import com.project.javaapifinance.builder.TransactionBuilder;
import com.project.javaapifinance.domain.Transaction;
import com.project.javaapifinance.repository.TransactionRepository;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TransactionServiceTests {
    
    @InjectMocks
    private TransactionService transactionService;

    @Mock
    private TransactionRepository transactionRepository;

    @Test
    public void mustReturnATransactionById() {
        Transaction transaction = new TransactionBuilder().createTransationWithId();
        given(transactionRepository.getOne(transaction.getId())).willReturn(transaction);

        assertThat(transactionService.getTransactionById(transaction.getId()), equalTo(transaction));
    }

    @Test
    public void mustDeleteATransactionById() {
        Transaction transaction = new TransactionBuilder().createTransationWithId();
        given(transactionRepository.getOne(transaction.getId())).willReturn(transaction);

        transactionService.deleteById(transaction.getId());

        verify(transactionRepository, times(1)).deleteById(transaction.getId());
    }

    @Test
    public void mustCreateATransaction() {
        Transaction transaction = new TransactionBuilder().createTransationWithoutId();
        given(transactionRepository.save(transaction)).willReturn(transaction);

        assertThat(transactionService.create(transaction), equalTo(transaction));
    }

    @Test
    public void mustUpdateATransaction() {
        Transaction transaction = new TransactionBuilder().createTransationWithId();
        given(transactionRepository.save(transaction)).willReturn(transaction);

        assertThat(transactionService.update(transaction), equalTo(transaction));
    }

}