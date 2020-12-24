package com.katalon.testops.commons.uploader;

import com.katalon.testops.commons.TestOpsConnector;
import com.katalon.testops.api.ApiClient;
import com.katalon.testops.api.model.FileResource;
import com.katalon.testops.api.model.UploadBatchFileResource;
import com.katalon.testops.commons.configuration.Configuration;
import com.katalon.testops.commons.core.HttpClientBuilder;
import com.katalon.testops.commons.helper.FileHelper;
import com.katalon.testops.commons.helper.GeneratorHelper;
import com.katalon.testops.commons.helper.LogHelper;
import org.slf4j.Logger;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.katalon.testops.commons.core.Constants.REPORT_PATTERN;

public class TestOpsReportUploader implements ReportUploader {

    private static final Logger logger = LogHelper.getLogger();

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
        String apiKey = configuration.getApiKey();
        if (Objects.isNull(apiKey) || apiKey.isEmpty()) {
            logger.warn("\n" +
                " ------------------------------------------------------------------------------------------------- \n" +
                "|                                                                                                 |\n" +
                "|     WARNING: Missing Katalon TestOps API Key. Reports will not be uploaded.                     |\n" +
                "|     https://docs.katalon.com/katalon-analytics/docs/ka-api-key.html#katalon-api-keys-usage      |\n" +
                "|                                                                                                 |\n" +
                " ------------------------------------------------------------------------------------------------- \n");
            return;
        }

        Long projectId = configuration.getProjectId();
        if (Objects.isNull(projectId)) {
            logger.warn("\n" +
                " --------------------------------------------------------------------------------------- \n" +
                "|                                                                                       |\n" +
                "|     WARNING: Missing Katalon TestOps Project ID. Reports will not be uploaded.        |\n" +
                "|                                                                                       |\n" +
                " --------------------------------------------------------------------------------------- \n");
            return;
        }

        logger.info("Start uploading testops report");

        Path reportFolder = configuration.getReportFolder();
        List<Path> reportPaths = FileHelper.scanFiles(reportFolder, reportPattern);
        List<FileResource> uploadInfos = testOpsConnector.getUploadUrls(projectId, reportPaths.size());
        String batch = GeneratorHelper.generateUploadBatch();
        List<UploadBatchFileResource> uploadBatchFileResources = new ArrayList<>(reportPaths.size());
        for (int i = 0; i < reportPaths.size(); i++) {
            boolean isEnd = i == (reportPaths.size() - 1);
            uploadFile(uploadInfos.get(i), reportPaths.get(i), isEnd)
                    .ifPresent(uploadBatchFileResources::add);
        }
        testOpsConnector.uploadTestOpsReport(uploadBatchFileResources, projectId, batch);
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
            logger.error("Error when uploading report", e);
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
