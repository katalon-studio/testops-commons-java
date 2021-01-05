package com.katalon.testops.commons.core;

import com.katalon.testops.commons.configuration.proxy.ProxyInformation;
import com.katalon.testops.commons.configuration.proxy.ProxyOption;
import com.katalon.testops.commons.configuration.proxy.ProxyRoutePlanner;
import com.katalon.testops.commons.helper.HttpHelper;
import org.apache.http.HttpHost;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

public class HttpClientRequestFactory extends TestOpsClientHttpRequestFactory {

    private final HttpComponentsClientHttpRequestFactory wrappedRequestFactory;

    public HttpClientRequestFactory() {
        this.wrappedRequestFactory = new HttpComponentsClientHttpRequestFactory();
    }

    @Override
    public void setConnectTimeout(int connectTimeout) {
        wrappedRequestFactory.setConnectTimeout(connectTimeout);
    }

    @Override
    public void setReadTimeout(int readTimeout) {
        wrappedRequestFactory.setReadTimeout(readTimeout);
    }

    @Override
    public void configureProxy(ProxyInformation proxyInfo) {
        if (proxyInfo == null || ProxyOption.NO_PROXY.equals(proxyInfo.getProxyOption())) {
            return;
        }

        HttpHost httpProxy = new HttpHost(proxyInfo.getHost(), proxyInfo.getPort());
        CredentialsProvider credentialsProvider = HttpHelper.createBasicCredentialsProvider(httpProxy, proxyInfo.getUsername(), proxyInfo.getPassword());
        SSLContext sslContext = null;
        try {
            sslContext = HttpHelper.createTrustAllSSLContext();
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }

        HttpClient httpClient = org.apache.http.impl.client.HttpClientBuilder.create()
                .useSystemProperties()
                .setSSLHostnameVerifier(NoopHostnameVerifier.INSTANCE)
                .setSSLContext(sslContext)
                .setRoutePlanner(new ProxyRoutePlanner(proxyInfo.getProxyOption(), httpProxy))
                .setDefaultCredentialsProvider(credentialsProvider)
                .build();
        wrappedRequestFactory.setHttpClient(httpClient);
    }

    @Override
    public ClientHttpRequest createRequest(URI uri, HttpMethod httpMethod) throws IOException {
        return wrappedRequestFactory.createRequest(uri, httpMethod);
    }
}
