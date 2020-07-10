package com.project.javaapifinance.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.project.javaapifinance.enums.ClassificationEnum;
import com.project.javaapifinance.enums.TransactionTypeEnum;

@Entity
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal value;
    @Enumerated(EnumType.STRING)
    private ClassificationEnum classification;
    @Enumerated(EnumType.STRING)
    private TransactionTypeEnum type;
    private LocalDateTime timeTransaction;
    private Account account;

    public Transaction() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public ClassificationEnum getClassification() {
        return classification;
    }

    public void setClassification(ClassificationEnum classification) {
        this.classification = classification;
    }

    public TransactionTypeEnum getType() {
        return type;
    }

    public void setType(TransactionTypeEnum type) {
        this.type = type;
    }

    public LocalDateTime getTimeTransaction() {
        return timeTransaction;
    }

    public void setTimeTransaction(LocalDateTime timeTransaction) {
        this.timeTransaction = timeTransaction;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}