package com.katalon.testops.uploader;

import com.katalon.testops.TestOpsConnector;
import com.katalon.testops.api.ApiClient;
import com.katalon.testops.api.model.FileResource;
import com.katalon.testops.api.model.UploadBatchFileResource;
import com.katalon.testops.configuration.Configuration;
import com.katalon.testops.core.HttpClientBuilder;
import com.katalon.testops.helper.FileHelper;
import com.katalon.testops.helper.GeneratorHelper;
import com.katalon.testops.helper.LogHelper;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.katalon.testops.core.Constants.REPORT_PATTERN;

public class TestOpsReportUploader implements ReportUploader {

    private final TestOpsConnector testOpsConnector;

    protected Configuration configuration;

    protected String reportPattern;

    public TestOpsReportUploader(Configuration configuration) {
        this.configuration = configuration;
        this.reportPattern = REPORT_PATTERN;
        this.testOpsConnector = new TestOpsConnector(createApiClient());
    }

    @Override
    public void upload() {
        List<Path> reportPaths = FileHelper.scanFiles(configuration.getResultsDirectory(), reportPattern);
        List<FileResource> uploadInfos = testOpsConnector.getUploadUrls(configuration.getProjectId(), reportPaths.size());
        String batch = GeneratorHelper.generateUploadBatch();
        List<UploadBatchFileResource> uploadBatchFileResources = new ArrayList<>(reportPaths.size());
        for (int i = 0; i < reportPaths.size(); i++) {
            boolean isEnd = i == (reportPaths.size() - 1);
            uploadFile(uploadInfos.get(i), reportPaths.get(i), isEnd)
                    .ifPresent(uploadBatchFileResources::add);
        }
        testOpsConnector.uploadTestOpsReport(uploadBatchFileResources, configuration.getProjectId(), batch);
    }

    public Optional<UploadBatchFileResource> uploadFile(FileResource info, Path path, boolean isEnd) {
        UploadBatchFileResource uploadBatchFileResource = new UploadBatchFileResource();
        try {
            testOpsConnector.uploadFile(info.getUploadUrl(), path.toUri());
            uploadBatchFileResource.setFileName(path.getFileName().toString());
            uploadBatchFileResource.setFolderPath(path.getParent().toString());
            uploadBatchFileResource.setUploadedPath(info.getPath());
            uploadBatchFileResource.setEnd(isEnd);
            return Optional.of(uploadBatchFileResource);
        } catch (Exception e) {
            LogHelper.getLogger().error(e);
            return Optional.empty();
        }
    }

    protected ApiClient createApiClient() {
        RestTemplate restTemplate = HttpClientBuilder
                .create()
                .build();
        ApiClient apiClient = new ApiClient(restTemplate);
        apiClient.setPassword(configuration.getApiKey());
        apiClient.setBasePath(configuration.getServerUrl());
        return apiClient;
    }
}
