package com.katalon.testops;

import com.katalon.testops.core.HttpClientBuilder;
import com.katalon.testops.core.web.ApiClient;
import com.katalon.testops.core.web.api.FileApi;
import com.katalon.testops.core.web.api.TestReportApi;
import com.katalon.testops.core.web.model.FileResource;
import com.katalon.testops.core.web.model.UploadBatchFileResource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

public class TestOpsConnector {

    private final ApiClient apiClient;

    public TestOpsConnector(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public List<FileResource> getUploadUrls(Long projectId, long numberUrl) {
        FileApi api = new FileApi(apiClient);
        return api.getUploadUrls(projectId, numberUrl);
    }

    public void uploadJunitFileInfo(
            Long projectId,
            String batch,
            String folderName,
            String fileName,
            String uploadedPath,
            boolean isEnd) {
        TestReportApi api = new TestReportApi(apiClient);
        api.uploadJUnitReports(String.valueOf(projectId), batch, folderName, String.valueOf(isEnd), fileName, uploadedPath, null);
    }

    public void uploadTestOpsReport(List<UploadBatchFileResource> body, Long projectId, String batch) {
        TestReportApi api = new TestReportApi(apiClient);
        api.processTestOpsReports(body, projectId, batch);
    }

    public void uploadFile(String url, URI fileUri) throws Exception {
        URI uri = new URI(url);

        final RequestEntity.BodyBuilder requestBuilder = RequestEntity.method(HttpMethod.PUT, uri);
        requestBuilder.contentType(MediaType.APPLICATION_OCTET_STREAM);
        requestBuilder.headers(new HttpHeaders());
        UrlResource body = new UrlResource(fileUri);
        RequestEntity<Object> requestEntity = requestBuilder.body(body);

        RestTemplate restTemplate = HttpClientBuilder
                .create()
                .build();
        restTemplate.exchange(requestEntity, Void.class);
    }
}
