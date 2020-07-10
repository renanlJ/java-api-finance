package com.project.javaapifinance.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.project.javaapifinance.enums.AccountTypeEnum;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long number;
    @Column(columnDefinition = "boolean default false") 
    private boolean blocked;
    @Enumerated(EnumType.STRING)
    private AccountTypeEnum type;
    private LocalDate creationDate;

    public Account() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getNumber() {
        return number;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean getBlocked() {
        return this.blocked;
    }

    public void setType(AccountTypeEnum type) {
        this.type = type;
    }

    public AccountTypeEnum getType() {
        return type;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

}