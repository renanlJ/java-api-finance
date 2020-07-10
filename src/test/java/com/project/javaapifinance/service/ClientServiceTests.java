package com.project.javaapifinance.service;

import com.project.javaapifinance.builder.ClientCreator;
import com.project.javaapifinance.domain.Client;
import com.project.javaapifinance.repository.ClientRepository;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientServiceTests {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository clientRepository;
    
    @Test
    public void mustRegisterAClient() {
        Client client = new ClientCreator().createClientWithoutId();
        given(clientRepository.save(client)).willReturn(client);

        assertThat(clientService.saveClient(client), equalTo(client));
    }

    @Test
    public void mustDeleteAcliente() {
        Client client = new ClientCreator().createClientWithId();
        given(clientRepository.getOne(client.getId())).willReturn(client);
        clientService.deleteClientById(client.getId());

        verify(clientRepository).deleteById(client.getId());
    }

    @Test
    public void mustUpdateAclient() {
        Client client = new ClientCreator().createClientWithId();
        given(clientRepository.save(client)).willReturn(client);

        assertThat(clientService.updateClient(client), equalTo(client));
    }

    @Test
    public void mustReturnAClientGivenSpecificId() {
        Client client = new ClientCreator().createClientWithId();
        given(clientRepository.getOne(client.getId())).willReturn(client);
        
        assertThat(clientService.getClientById(client.getId()), equalTo(client));
    }
    
}