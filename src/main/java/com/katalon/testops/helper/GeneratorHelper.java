package com.katalon.testops.helper;

import java.util.Date;
import java.util.UUID;

public class GeneratorHelper {

    public static String generateUniqueValue() {
        return UUID.randomUUID().toString();
    }

    public static String generateUploadBatch() {
        return new Date().getTime() + "-" + generateUniqueValue();
    }
}
