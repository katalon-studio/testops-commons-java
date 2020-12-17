package com.katalon.testops.helper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

public class ObjectMapperSingleton {

    private ObjectMapperSingleton() {
    }

    public static ObjectMapper getInstance() {
        return ObjectMapperHolder.INSTANCE;
    }

    private static class ObjectMapperHolder {
        private static final ObjectMapper INSTANCE = new ObjectMapper()
                .setSerializationInclusion(NON_NULL)
                .configure(SerializationFeature.INDENT_OUTPUT, true)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }
}
