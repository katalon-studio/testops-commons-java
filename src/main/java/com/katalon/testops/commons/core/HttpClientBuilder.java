package com.katalon.testops.commons.core;

import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class HttpClientBuilder {

    private static final int DEFAULT_CONNECT_TIMEOUT = 60000; // milliseconds

    private static final int DEFAULT_SOCKET_TIMEOUT = 60000; // milliseconds

    private int connectTimeout = DEFAULT_CONNECT_TIMEOUT;

    private int readTimeout = DEFAULT_SOCKET_TIMEOUT;


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

    public RestTemplate build() {
        RestTemplate restTemplate = new RestTemplate();
        // This allows us to read the response more than once - Necessary for debugging.
        SimpleClientHttpRequestFactory simpleRequestFactory = new SimpleClientHttpRequestFactory();
        simpleRequestFactory.setConnectTimeout(connectTimeout);
        simpleRequestFactory.setReadTimeout(readTimeout);
        BufferingClientHttpRequestFactory bufferingRequestFactory = new BufferingClientHttpRequestFactory(simpleRequestFactory);

        restTemplate.setRequestFactory(bufferingRequestFactory);
        return restTemplate;
    }
}
