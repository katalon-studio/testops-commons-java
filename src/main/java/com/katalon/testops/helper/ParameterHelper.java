package com.katalon.testops.helper;

import java.io.InputStream;
import java.util.Properties;

public class ParameterHelper {

    private static Properties properties;

    static {
        loadParameters();
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static String getOrDefault(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public static void set(String key, String value) {
        if (key != null && value != null) {
            properties.setProperty(key, value);
        }
    }

    private static void loadParameters() {
        properties = new Properties();
        String filePath = "testops.properties";
        try (InputStream inputStream = ParameterHelper.class.getClassLoader().getResourceAsStream(filePath)) {
            properties.load(inputStream);
        } catch (Exception ex) {
            LogHelper.getLogger().error("Fail to load properties from " + filePath, ex);
        }
        properties.putAll(System.getenv());
        properties.putAll(System.getProperties());
    }
}

