package com.project.javaapifinance.service;

import com.project.javaapifinance.builder.ClientCreator;
import com.project.javaapifinance.domain.Client;
import com.project.javaapifinance.repository.ClientRepository;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.BDDMockito.given;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientServiceTests {

    @InjectMocks
    private ClientService clientService;

    @Mock
    private ClientRepository repository;
    
    @Test
    public void mustRegisterAClient() {
        Client client = new ClientCreator().createClientWithoutId();
        given(repository.save(client)).willReturn(client);

        assertThat(clientService.saveClient(client), equalTo(client));
    }
    
}