package com.katalon.testops.model;

import java.util.Collection;

public class TestCases implements IReport {

    private Collection<TestResult> testCases;

    public Collection<TestResult> getTestCases() {
        return testCases;
    }

    public void setTestCases(Collection<TestResult> testCases) {
        this.testCases = testCases;
    }
}
