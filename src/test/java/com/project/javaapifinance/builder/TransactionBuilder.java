package com.project.javaapifinance.builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Random;

import com.project.javaapifinance.domain.Account;
import com.project.javaapifinance.domain.Transaction;
import com.project.javaapifinance.enums.ClassificationEnum;
import com.project.javaapifinance.enums.TransactionTypeEnum;

public class TransactionBuilder {

    private Transaction transation;
    
    public TransactionBuilder() {
        this.transation = new Transaction();
    }

    public TransactionBuilder id(Long id) {
        this.transation.setId(id);
        return this;
    }

    public TransactionBuilder value(BigDecimal value) {
        this.transation.setValue(value);
        return this;
    }

    public TransactionBuilder classification(ClassificationEnum classification) {
        this.transation.setClassification(classification);
        return this;
    }

    public TransactionBuilder type(TransactionTypeEnum type) {
        this.transation.setType(type);
        return this;
    }

    public TransactionBuilder timeTransaction(LocalDateTime timeTransaction) {
        this.transation.setTimeTransaction(timeTransaction);
        return this;
    }

    public TransactionBuilder account(Account account) {
        this.transation.setAccount(account);
        return this;
    }

    public Transaction build() {
        return this.transation;
    }

    public Transaction createTransationWithId() {
        return new TransactionBuilder()
            .id(Long.valueOf(new Random().nextLong()))
            .value(new BigDecimal(1000))
            .classification(ClassificationEnum.COURSES)
            .type(TransactionTypeEnum.OUT)
            .timeTransaction(LocalDateTime.of(2020, 07, 10, 00, 45, 03))
            .build();
    }

    public Transaction createTransationWithoutId() {
        return new TransactionBuilder()
            .value(new BigDecimal(1000))
            .classification(ClassificationEnum.COURSES)
            .type(TransactionTypeEnum.OUT)
            .timeTransaction(LocalDateTime.of(2020, 07, 10, 00, 45, 03))
            .build();
    }

}