package com.katalon.testops;

import com.katalon.testops.core.web.ApiClient;
import com.katalon.testops.core.web.api.TestReportApi;
import com.katalon.testops.core.web.model.UploadBatchFileResource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class TestOpsConnector {

    private final ApiClient apiClient;

    public TestOpsConnector(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public void uploadJunitFileInfo(
            long projectId,
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

    public void uploadFile(String url, URI fileUri) throws MalformedURLException, URISyntaxException {
        MediaType contentType = MediaType.APPLICATION_OCTET_STREAM;
        final HttpHeaders headerParams = new HttpHeaders();
        ParameterizedTypeReference<Void> returnType = new ParameterizedTypeReference<Void>() {
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(new String[]{});

        UrlResource body = new UrlResource(fileUri);
        apiClient.makeRequest(url, HttpMethod.PUT, body, headerParams, null, accept, contentType, returnType);
    }
}
