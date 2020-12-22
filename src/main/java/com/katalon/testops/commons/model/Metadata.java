package com.katalon.testops.commons.model;

public class Metadata implements IReport {

    private String framework;

    private String language;

    private String version;

    private String buildLabel;

    private String buildUrl;

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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
