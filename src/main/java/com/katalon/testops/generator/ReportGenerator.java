package com.katalon.testops.generator;

import com.katalon.testops.model.*;

public interface ReportGenerator {

    void write(Execution execution);

    void write(TestSuites testSuites);

    void write(TestCases testCases);

    void write(Metadata metadata);
}
