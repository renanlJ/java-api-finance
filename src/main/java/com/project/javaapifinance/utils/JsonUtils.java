package com.project.javaapifinance.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
    
    public static String jsonString(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}