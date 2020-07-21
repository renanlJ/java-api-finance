package com.project.javaapifinance.controller;

import java.util.List;
import com.project.javaapifinance.domain.Client;
import com.project.javaapifinance.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/")
    public List<Client> getAllClients() {
        return clientService.findAllClients();
    }
    
}