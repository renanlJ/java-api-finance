package com.project.javaapifinance.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import com.project.javaapifinance.builder.ClientCreator;
import com.project.javaapifinance.domain.Client;
import com.project.javaapifinance.service.ClientService;
import com.project.javaapifinance.utils.JsonUtils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = ClientController.class)
public class ClientControllerTests {
    
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;

    @Test
    public void mustReturn200WhenGetClients() throws Exception {
        this.mockMvc.perform(get("/client/")).andExpect(status().isOk());
    }

    @Test
    public void mustReturn200WhenGetAClientById() throws Exception {
        this.mockMvc.perform(get("/client/1")).andExpect(status().isOk());
    }

    @Test
    public void mustReturn201WhenCreateAClient() throws Exception {
        Client client = new ClientCreator().createClientWithoutId();
        String body = JsonUtils.jsonString(client);

        this.mockMvc.perform(post("/client/").content(body).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated());
    }

    @Test
    public void mustReturn200WhenUpdateAClient() throws Exception {
        Client client = new ClientCreator().createClientWithId();
        String body = JsonUtils.jsonString(client);

        this.mockMvc.perform(put("/client/").content(body).contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
    }

    @Test
    public void mustReturn204WhenDeleteAClient() throws Exception {
        this.mockMvc.perform(delete("/client/1"))
                    .andExpect(status().isNoContent());
    }
}