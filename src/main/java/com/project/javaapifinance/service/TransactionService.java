package com.project.javaapifinance.service;

import com.project.javaapifinance.domain.Transaction;
import com.project.javaapifinance.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    
    @Autowired
    public TransactionRepository transactionRepository;

    public Transaction getTransactionById(Long id) {
        return transactionRepository.getOne(id);
    }

	public void deleteById(Long id) {
        transactionRepository.deleteById(id);
	}

	public Transaction create(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

	public Transaction update(Transaction transaction) {
		return transactionRepository.save(transaction);
	}
}