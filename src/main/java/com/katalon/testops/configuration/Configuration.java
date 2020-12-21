package com.katalon.testops.configuration;

import java.nio.file.Path;

public class Configuration {

    private String serverUrl;

    private String apiKey;

    private Long projectId;

    private Path resultsDirectory;

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Path getResultsDirectory() {
        return resultsDirectory;
    }

    public void setResultsDirectory(Path resultsDirectory) {
        this.resultsDirectory = resultsDirectory;
    }
}
