package com.project.javaapifinance.repository;

import com.project.javaapifinance.domain.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    
}