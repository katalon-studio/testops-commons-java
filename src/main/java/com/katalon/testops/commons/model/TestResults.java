package com.katalon.testops.commons.model;

import java.util.Collection;

public class TestResults implements IReport {

    private Collection<TestResult> results;

    public Collection<TestResult> getResults() {
        return results;
    }

    public void setResults(Collection<TestResult> results) {
        this.results = results;
    }
}
