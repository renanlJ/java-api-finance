package com.project.javaapifinance.utils;

import java.util.List;

import br.com.caelum.stella.ValidationMessage;
import br.com.caelum.stella.validation.CPFValidator;

public class CpfUtils {

    public static boolean validateCpf(String cpf) {
        boolean valid = false;

        CPFValidator cpfValidator = new CPFValidator();
        List<ValidationMessage> errors = cpfValidator.invalidMessagesFor(cpf);

        if(errors.size() == 0){
            valid = true;
        }
        
        return valid;
    }

    public static String generateCpf() {
        return new CPFValidator().generateRandomValid();
    }
    
}