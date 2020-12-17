package com.katalon.testops.model;

import java.util.Collection;

public class TestSuites implements IReport {

    private Collection<TestSuite> suites;

    public Collection<TestSuite> getSuites() {
        return suites;
    }

    public void setSuites(Collection<TestSuite> suites) {
        this.suites = suites;
    }
}
