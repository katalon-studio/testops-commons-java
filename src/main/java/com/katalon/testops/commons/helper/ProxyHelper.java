package com.katalon.testops.commons.helper;

import com.github.markusbernhardt.proxy.ProxySearch;
import com.github.markusbernhardt.proxy.selector.misc.BufferedProxySelector;
import com.github.markusbernhardt.proxy.util.PlatformUtil;

import java.net.ProxySelector;
import java.util.concurrent.TimeUnit;

public class ProxyHelper {

    public static ProxySelector getAutoProxySelector() {
        ProxySelector proxySelector = getProxySearch().getProxySelector();
        if (proxySelector == null) {
            proxySelector = ProxySelector.getDefault();
        }
        return proxySelector;
    }

    private static ProxySearch getProxySearch() {
        ProxySearch proxySearch = ProxySearch.getDefaultProxySearch();
        if (PlatformUtil.getCurrentPlattform() == PlatformUtil.Platform.WIN) {
            proxySearch.addStrategy(ProxySearch.Strategy.IE);
            proxySearch.addStrategy(ProxySearch.Strategy.FIREFOX);
        } else if (PlatformUtil.getCurrentPlattform() == PlatformUtil.Platform.LINUX) {
            proxySearch.addStrategy(ProxySearch.Strategy.GNOME);
            proxySearch.addStrategy(ProxySearch.Strategy.KDE);
            proxySearch.addStrategy(ProxySearch.Strategy.FIREFOX);
        }
        // Cache 50 hosts for up to 30 minutes.
        proxySearch.setPacCacheSettings(50, TimeUnit.MINUTES.toMillis(30), BufferedProxySelector.CacheScope.CACHE_SCOPE_URL);
        return proxySearch;
    }
}
