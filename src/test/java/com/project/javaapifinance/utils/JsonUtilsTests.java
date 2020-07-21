package com.project.javaapifinance.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.project.javaapifinance.builder.ClientCreator;
import com.project.javaapifinance.domain.Client;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JsonUtilsTests {
    
    @Test
    public void mustConvertAnObjectToJson() {
        Client client = new ClientCreator().createClientWithId();
        String jsonString = JsonUtils.jsonString(client);

        assertTrue(jsonString.contains(client.getName()));
    }

}