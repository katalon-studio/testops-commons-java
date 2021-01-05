package com.katalon.testops.commons.helper;

import com.katalon.testops.commons.core.TrustAllManager;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class HttpHelper {

    public static final String TLS = "TLSv1.2";

    public static CredentialsProvider createBasicCredentialsProvider(HttpHost origin, String username, String password) {
        CredentialsProvider result = new BasicCredentialsProvider();
        if (isNotBlank(username) && isNotBlank(password)) {
            Credentials basicCredentials = new UsernamePasswordCredentials(username, password);
            result.setCredentials(new AuthScope(origin), basicCredentials);
        }
        return result;
    }

    public static SSLContext createTrustAllSSLContext() throws NoSuchAlgorithmException, KeyManagementException {
        SSLContext sc = SSLContext.getInstance(TLS);
        sc.init(createKeyManagers(), createTrustManagers(), null);
        return sc;
    }

    public static TrustManager[] createTrustManagers() {
        return new TrustManager[]{new TrustAllManager()};
    }

    public static KeyManager[] createKeyManagers() {
        return new KeyManager[0];
    }
}
