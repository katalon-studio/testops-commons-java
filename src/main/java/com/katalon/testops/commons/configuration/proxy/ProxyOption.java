package com.katalon.testops.commons.configuration.proxy;

public enum ProxyOption {

    NO_PROXY("No Proxy"),
    USE_SYSTEM("Use system proxy configuration"),
    MANUAL_CONFIG("Manual proxy configuration");

    private final String displayName;

    ProxyOption(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
