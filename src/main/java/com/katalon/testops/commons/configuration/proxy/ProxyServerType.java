package com.katalon.testops.commons.configuration.proxy;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum ProxyServerType {
    HTTP, HTTPS, SOCKS;

    public static String[] stringValues() {
        ProxyServerType[] values = values();
        return Arrays.stream(values)
                .map(ProxyServerType::toString)
                .collect(Collectors.toList())
                .toArray(new String[values.length]);
    }
}
