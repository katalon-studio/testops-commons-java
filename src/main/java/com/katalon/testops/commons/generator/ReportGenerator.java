package com.katalon.testops.commons.generator;

import com.katalon.testops.commons.model.Execution;
import com.katalon.testops.commons.model.Metadata;
import com.katalon.testops.commons.model.TestResults;
import com.katalon.testops.commons.model.TestSuites;

public interface ReportGenerator {

    void write(Execution execution);

    void write(TestSuites testSuites);

    void write(TestResults testResults);

    void write(Metadata metadata);
}
