package com.katalon.testops.commons.configuration.proxy;

public class ProxyInformation {

    private ProxyOption proxyOption = ProxyOption.NO_PROXY;

    private ProxyServerType proxyServerType = ProxyServerType.HTTP;

    private String host;

    private int port;

    private String username;

    private String password;

    public ProxyOption getProxyOption() {
        return proxyOption;
    }

    public void setProxyOption(ProxyOption proxyOption) {
        this.proxyOption = proxyOption;
    }

    public ProxyServerType getProxyServerType() {
        return proxyServerType;
    }

    public void setProxyServerType(ProxyServerType proxyServerType) {
        this.proxyServerType = proxyServerType;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setPort(String port) {
        try {
            this.port = Integer.parseInt(port.trim());
        } catch (NumberFormatException ex) {
            this.port = -1;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ProxyInformation { "
                + "proxyOption=" + proxyOption + ", "
                + "proxyServerType=" + proxyServerType + ", "
                + "username=" + username + ", "
                + "password=" + "********" + ", "
                + "proxyServerAddress=" + host + ", "
                + "proxyServerPort=" + port + ", "
                + " }";
    }
}
