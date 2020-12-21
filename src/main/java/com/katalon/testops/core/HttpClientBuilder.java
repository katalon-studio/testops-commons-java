package com.katalon.testops.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.threetenbp.ThreeTenModule;
import com.katalon.testops.core.web.CustomInstantDeserializer;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.threeten.bp.Instant;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZonedDateTime;

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
        for (HttpMessageConverter<?> converter : restTemplate.getMessageConverters()) {
            if (converter instanceof AbstractJackson2HttpMessageConverter) {
                ObjectMapper mapper = ((AbstractJackson2HttpMessageConverter) converter).getObjectMapper();
                ThreeTenModule module = new ThreeTenModule();
                module.addDeserializer(Instant.class, CustomInstantDeserializer.INSTANT);
                module.addDeserializer(OffsetDateTime.class, CustomInstantDeserializer.OFFSET_DATE_TIME);
                module.addDeserializer(ZonedDateTime.class, CustomInstantDeserializer.ZONED_DATE_TIME);
                mapper.registerModule(module);
            }
        }
        // This allows us to read the response more than once - Necessary for debugging.
        SimpleClientHttpRequestFactory simpleRequestFactory = new SimpleClientHttpRequestFactory();
        simpleRequestFactory.setConnectTimeout(connectTimeout);
        simpleRequestFactory.setReadTimeout(readTimeout);
        BufferingClientHttpRequestFactory bufferingRequestFactory = new BufferingClientHttpRequestFactory(simpleRequestFactory);

        restTemplate.setRequestFactory(bufferingRequestFactory);
        return restTemplate;
    }
}
