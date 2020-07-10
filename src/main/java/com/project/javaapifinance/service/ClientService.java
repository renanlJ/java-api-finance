package com.project.javaapifinance.service;

import com.project.javaapifinance.domain.Client;
import com.project.javaapifinance.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    
    @Autowired
    private ClientRepository clientRepository;

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

	public void deleteClientById(Long id) {
        clientRepository.deleteById(id);;
	}

	public Client updateClient(Client client) {
		return clientRepository.save(client);
	}

	public Client getClientById(Long id) {
		return clientRepository.getOne(id);
	}

}