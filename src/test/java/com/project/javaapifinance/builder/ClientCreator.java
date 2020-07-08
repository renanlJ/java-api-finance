package com.project.javaapifinance.builder;

import java.util.Random;

import com.project.javaapifinance.domain.Client;
import com.project.javaapifinance.utils.CpfUtils;

public class ClientCreator {

    private Client client;
    private static final int MAX_VALUE = 999;

    public ClientCreator() {
        this.client = new Client();
    }

    public ClientCreator withId(Long id) {
        this.client.setId(id);
        return this;
    }

    public ClientCreator withName(String name) {
        this.client.setName(name);
        return this;
    }
    
    public ClientCreator withCpf(String cpf) {
        this.client.setCpf(cpf);
        return this;
    }

    public ClientCreator withEmail(String email) {
        this.client.setEmail(email);
        return this;
    }

    public ClientCreator withCell(String cell) {
        this.client.setCell(cell);
        return this;
    }

    public ClientCreator livesOnStreet(String address) {
        this.client.setAddress(address);
        return this;
    }

    public ClientCreator zipCodeis(String zipCode) {
        this.client.setZipCode(zipCode);
        return this;
    }

    public ClientCreator livesInCity(String city) {
        this.client.setCity(city);
        return this;
    }

    public ClientCreator livesInCountry(String country) {
        this.client.setCountry(country);
        return this;
    }

    public Client buidClient() {
        return this.client;
    }

    public Client createClientWithId(){
        String name = addSufix("random name ");

        return new ClientCreator()
            .withId(Long.valueOf(new Random().nextLong()))
            .withName(name)
            .withCpf(CpfUtils.generateCpf())
            .withEmail(createEmail(name))
            .withCell("5511988221314")
            .livesOnStreet("Sapopemba Avenue, 6214")
            .zipCodeis("03374-001")
            .livesInCountry("Brazil")
            .livesInCity("Saint Paul")
            .buidClient();
    }

    public Client createClientWithoutId(){
        String name = addSufix("random name ");

        return new ClientCreator()
            .withName(name)
            .withCpf(CpfUtils.generateCpf())
            .withEmail(createEmail(name))
            .withCell("5511988221314")
            .livesOnStreet("Sapopemba Avenue, 6214")
            .zipCodeis("03374-001")
            .livesInCountry("Brazil")
            .livesInCity("Saint Paul")
            .buidClient();
    }

    private String addSufix(String prefix) {
        return prefix + new Random().nextInt(MAX_VALUE);
    }

    private String createEmail(String name) {
        return name.toLowerCase().replaceAll("\\s+","") + "@email.com";
    }

}