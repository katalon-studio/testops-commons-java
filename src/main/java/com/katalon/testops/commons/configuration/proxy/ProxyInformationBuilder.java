package com.katalon.testops.commons.configuration.proxy;

import com.katalon.testops.commons.helper.ParameterHelper;

import static com.katalon.testops.commons.core.Constants.*;

public class ProxyInformationBuilder {

    private ProxyOption proxyOption;

    private ProxyServerType proxyServerType;

    private String host;

    private Integer port;

    private String username;

    private String password;

    private ProxyInformationBuilder() {
    }

    public static ProxyInformationBuilder create() {
        return new ProxyInformationBuilder();
    }

    private ProxyOption getProxyOption() {
        if (proxyOption != null) {
            return proxyOption;
        } else {
            String proxyOption = ParameterHelper.getOrDefaultIfBlank(TESTOPS_PROXY_OPTION, ProxyOption.NO_PROXY.name());
            return ProxyOption.valueOf(proxyOption);
        }
    }

    public ProxyInformationBuilder setProxyOption(ProxyOption proxyOption) {
        this.proxyOption = proxyOption;
        return this;
    }

    private ProxyServerType getProxyServerType() {
        if (proxyServerType != null) {
            return proxyServerType;
        } else {
            String serverType = ParameterHelper.getOrDefaultIfBlank(TESTOPS_PROXY_SERVER_TYPE, ProxyServerType.HTTP.name());
            return ProxyServerType.valueOf(serverType);
        }
    }

    public ProxyInformationBuilder setProxyServerType(ProxyServerType proxyServerType) {
        this.proxyServerType = proxyServerType;
        return this;
    }

    private String getProxyHost() {
        if (host != null) {
            return host;
        } else {
            return ParameterHelper.getOrDefaultIfBlank(TESTOPS_PROXY_HOST, "");
        }
    }

    public ProxyInformationBuilder setProxyHost(String host) {
        this.host = host;
        return this;
    }

    private String getProxyPort() {
        if (port != null) {
            return port.toString();
        } else {
            return ParameterHelper.getOrDefaultIfBlank(TESTOPS_PROXY_PORT, "-1");
        }
    }

    public ProxyInformationBuilder setProxyPort(int port) {
        this.port = port;
        return this;
    }

    private String getProxyUsername() {
        if (username != null) {
            return username;
        } else {
            return ParameterHelper.getOrDefaultIfBlank(TESTOPS_PROXY_USERNAME, "");
        }
    }

    public ProxyInformationBuilder setProxyUsername(String username) {
        this.username = username;
        return this;
    }

    private String getProxyPassword() {
        if (password != null) {
            return password;
        } else {
            return ParameterHelper.getOrDefaultIfBlank(TESTOPS_PROXY_PASSWORD, "");
        }
    }

    public ProxyInformationBuilder setProxyPassword(String password) {
        this.password = password;
        return this;
    }

    public ProxyInformation build() {
        ProxyInformation proxyInfo = new ProxyInformation();
        proxyInfo.setProxyOption(getProxyOption());
        proxyInfo.setProxyServerType(getProxyServerType());
        proxyInfo.setHost(getProxyHost());
        proxyInfo.setPort(getProxyPort());
        proxyInfo.setUsername(getProxyUsername());
        proxyInfo.setPassword(getProxyPassword());
        return proxyInfo;
    }
}
