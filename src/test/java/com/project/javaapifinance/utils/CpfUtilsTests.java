package com.project.javaapifinance.utils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CpfUtilsTests {

    @Test
    public void mustGenerateValidCpf() {
        String cpf = CpfUtils.generateCpf();
        assertTrue(CpfUtils.validateCpf(cpf));
    }

    @Test
    public void mustValidateAIncorrectCpf() {
        String cpf = CpfUtils.generateCpf() + "0000";
        assertFalse(CpfUtils.validateCpf(cpf));
    }
    
}