package com.katalon.testops.commons.configuration.proxy;

import com.katalon.testops.commons.helper.ProxyHelper;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.conn.SystemDefaultRoutePlanner;
import org.apache.http.protocol.HttpContext;

public class ProxyRoutePlanner implements HttpRoutePlanner {

    private final ProxyOption proxyOption;

    private final HttpHost httpHost;

    public ProxyRoutePlanner(ProxyOption proxyOption, HttpHost httpHost) {
        this.proxyOption = proxyOption;
        this.httpHost = httpHost;
    }

    @Override
    public HttpRoute determineRoute(HttpHost target, HttpRequest request, HttpContext context) throws HttpException {
        if (ProxyOption.USE_SYSTEM.equals(proxyOption)) {
            return new SystemDefaultRoutePlanner(ProxyHelper.getAutoProxySelector()).determineRoute(target, request, context);
        } else {
            return new DefaultProxyRoutePlanner(httpHost).determineRoute(target, request, context);
        }
    }
}
