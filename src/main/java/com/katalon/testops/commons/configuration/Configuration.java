package com.katalon.testops.commons.configuration;

import java.nio.file.Path;

public class Configuration {

    private String serverUrl;

    private String apiKey;

    private Long projectId;

    private Path reportFolder;

    private String buildLabel;

    private String buildUrl;

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

    public Path getReportFolder() {
        return reportFolder;
    }

    public void setReportFolder(Path reportFolder) {
        this.reportFolder = reportFolder;
    }

    public String getBuildLabel() {
        return buildLabel;
    }

    public void setBuildLabel(String buildLabel) {
        this.buildLabel = buildLabel;
    }

    public String getBuildUrl() {
        return buildUrl;
    }

    public void setBuildUrl(String buildUrl) {
        this.buildUrl = buildUrl;
    }
}
