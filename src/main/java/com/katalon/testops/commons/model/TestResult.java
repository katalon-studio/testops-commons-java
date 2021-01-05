package com.katalon.testops.commons.model;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TestResult implements IReport, WithUuid {

    private String uuid;

    private String parentUuid;

    private String name;

    private String suiteName;

    private String description;

    private Map<String, String> parameters;

    private Status status;

    private List<Error> errors = new ArrayList<>();

    private Long start;

    private Long stop;

    private Long duration;

    private String thread;

    private String host;

    @Override
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String getParentUuid() {
        return parentUuid;
    }

    public void setParentUuid(String parentUuid) {
        this.parentUuid = parentUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuiteName() {
        return suiteName;
    }

    public void setSuiteName(String suiteName) {
        this.suiteName = suiteName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getStop() {
        return stop;
    }

    public void setStop(Long stop) {
        this.stop = stop;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getThread() {
        return thread;
    }

    public void setThread(String thread) {
        this.thread = thread;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void addError(final Throwable throwable) {
        String message = getErrorMessage(throwable);
        String stackTrace = getStackTraceAsString(throwable);
        addError(message, stackTrace);

    }

    public void addError(String message, String stackTrace) {
        Error error = new Error();
        error.setMessage(message);
        error.setStackTrace(stackTrace);
        errors.add(error);

    }

    private String getStackTraceAsString(final Throwable throwable) {
        final StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    private String getErrorMessage(final Throwable throwable) {
        return Optional.ofNullable(throwable.getMessage())
            .orElse(throwable.getClass().getName());
    }
}
