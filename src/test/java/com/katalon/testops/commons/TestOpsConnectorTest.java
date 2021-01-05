package com.katalon.testops.commons;

import com.katalon.testops.api.ApiClient;
import com.katalon.testops.api.model.FileResource;
import com.katalon.testops.commons.configuration.Configuration;
import com.katalon.testops.commons.configuration.ConfigurationCreator;
import com.katalon.testops.commons.configuration.TestOpsConfigurationCreator;
import com.katalon.testops.commons.core.HttpClientBuilder;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class TestOpsConnectorTest {

    private Configuration configuration;

    private ApiClient apiClient;

    private TestOpsConnector testOpsConnector;

    private ApiClient createApiClient() {
        RestTemplate restTemplate = HttpClientBuilder
                .create()
                .setProxyInformation(configuration.getProxyInformation())
                .build();
        ApiClient apiClient = new ApiClient(restTemplate);
        apiClient.setPassword(configuration.getApiKey());
        apiClient.setBasePath(configuration.getServerUrl());
        System.out.println(configuration.getServerUrl());
        return apiClient;
    }

    @BeforeClass
    public void setUp() {
        ConfigurationCreator configurationCreator = new TestOpsConfigurationCreator();
        configuration = configurationCreator.createConfiguration();
        apiClient = createApiClient();
        testOpsConnector = new TestOpsConnector(apiClient);
    }

    @Parameters("numberUrl")
    @Test
    public void testGetUploadUrls(@Optional("3") int numberUrl) {
        List<FileResource> uploadUrls = testOpsConnector.getUploadUrls(configuration.getProjectId(), numberUrl);
        System.out.println(uploadUrls);
        Assert.assertEquals(uploadUrls.size(), 3);
    }
}
