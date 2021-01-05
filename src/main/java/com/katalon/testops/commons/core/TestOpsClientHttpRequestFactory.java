package com.katalon.testops.commons.core;

import com.katalon.testops.commons.configuration.proxy.ProxyInformation;
import org.springframework.http.client.ClientHttpRequestFactory;

public abstract class TestOpsClientHttpRequestFactory implements ClientHttpRequestFactory {

    public abstract void setConnectTimeout(int connectTimeout);

    public abstract void setReadTimeout(int readTimeout);

    public abstract void configureProxy(ProxyInformation proxyInformation);
}
