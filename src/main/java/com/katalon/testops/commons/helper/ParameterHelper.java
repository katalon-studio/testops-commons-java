package com.katalon.testops.commons.helper;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class ParameterHelper {

    private static final Logger logger = LogHelper.getLogger();

    private static Properties properties;

    static {
        loadParameters();
    }

    public static String toEnvironmentName(String key) {
        return key.toUpperCase().replace(".", "_");
    }

    public static String get(String key) {
        String environmentName = toEnvironmentName(key);
        String value = properties.getProperty(environmentName);
        if (StringUtils.isBlank(value)) {
            value = properties.getProperty(key);
        }
        return value;
    }

    public static String getOrDefaultIfBlank(String key, String defaultValue) {
        String value = get(key);
        if (StringUtils.isBlank(value)) {
            value = defaultValue;
        }
        return value;
    }

    public static void set(String key, String value) {
        if (key != null && value != null) {
            properties.setProperty(key, value);
        }
    }

    private static void loadParameters() {
        properties = new Properties();

        String filePath = "testops.properties";
        URL url = ParameterHelper.class.getClassLoader().getResource(filePath);
        if (url != null) {
            logger.info("Load properties from {}", filePath);
            try (InputStream inputStream = url.openStream()) {
                properties.load(inputStream);
            } catch (Exception ex) {
                logger.error("Fail to load properties from " + filePath, ex);
            }
        } else {
            logger.info("Cannot find {} file", filePath);
        }

        logger.info("Load properties from system environment variable");
        properties.putAll(System.getenv());

        logger.info("Load properties from system properties");
        properties.putAll(System.getProperties());
    }
}

