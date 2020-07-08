package com.project.javaapifinance.repository;

import com.project.javaapifinance.domain.Client;

import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
    
}