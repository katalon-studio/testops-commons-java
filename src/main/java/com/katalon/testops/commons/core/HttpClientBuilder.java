package com.katalon.testops.commons.core;

import com.katalon.testops.commons.configuration.proxy.ProxyInformation;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class HttpClientBuilder {

    private static final int DEFAULT_CONNECT_TIMEOUT = 60000; // milliseconds

    private static final int DEFAULT_SOCKET_TIMEOUT = 60000; // milliseconds

    private int connectTimeout = DEFAULT_CONNECT_TIMEOUT;

    private int readTimeout = DEFAULT_SOCKET_TIMEOUT;

    private ProxyInformation proxyInformation;

    private HttpClientBuilder() {
    }

    public static HttpClientBuilder create() {
        return new HttpClientBuilder();
    }

    public int getConnectTimeout() {
        return connectTimeout;
    }

    public HttpClientBuilder setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
        return this;
    }

    public int getReadTimeout() {
        return readTimeout;
    }

    public HttpClientBuilder setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
        return this;
    }

    public ProxyInformation getProxyInformation() {
        return proxyInformation;
    }

    public HttpClientBuilder setProxyInformation(ProxyInformation proxyInformation) {
        this.proxyInformation = proxyInformation;
        return this;
    }

    public RestTemplate build() {
        RestTemplate restTemplate = new RestTemplate();
        TestOpsClientHttpRequestFactory requestFactory = new HttpClientRequestFactory();
        requestFactory.configureProxy(proxyInformation);
        requestFactory.setConnectTimeout(connectTimeout);
        requestFactory.setReadTimeout(readTimeout);
        BufferingClientHttpRequestFactory bufferingRequestFactory = new BufferingClientHttpRequestFactory(requestFactory);

        restTemplate.setRequestFactory(bufferingRequestFactory);
        return restTemplate;
    }
}
