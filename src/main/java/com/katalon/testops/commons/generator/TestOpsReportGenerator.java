package com.katalon.testops.commons.generator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.katalon.testops.commons.helper.ObjectMapperSingleton;
import com.katalon.testops.commons.model.Execution;
import com.katalon.testops.commons.model.Metadata;
import com.katalon.testops.commons.model.TestResults;
import com.katalon.testops.commons.model.TestSuites;

import java.io.IOException;
import java.nio.file.Path;

import static com.katalon.testops.commons.core.Constants.REPORT_FILE_EXTENSION;
import static com.katalon.testops.commons.helper.FileHelper.ensureDirectory;

public class TestOpsReportGenerator implements ReportGenerator {

    private final ObjectMapper objectMapper;

    private final Path outputDirectory;

    public TestOpsReportGenerator(Path outputDirectory) {
        this.objectMapper = ObjectMapperSingleton.getInstance();
        this.outputDirectory = outputDirectory;
        ensureDirectory(outputDirectory);
    }

    @Override
    public void write(Metadata metadata) {
        try {
            write(metadata, "metadata" + REPORT_FILE_EXTENSION);
        } catch (IOException e) {
            throw new RuntimeException("Unable to write TestOps metadata", e);
        }
    }

    @Override
    public void write(Execution execution) {
        try {
            write(execution, "execution" + REPORT_FILE_EXTENSION);
        } catch (IOException e) {
            throw new RuntimeException("Unable to write TestOps execution", e);
        }
    }

    @Override
    public void write(TestSuites testSuites) {
        try {
            write(testSuites, "suites" + REPORT_FILE_EXTENSION);
        } catch (IOException e) {
            throw new RuntimeException("Unable to write TestOps test suites", e);
        }
    }

    @Override
    public void write(TestResults testResults) {
        try {
            write(testResults, "results" + REPORT_FILE_EXTENSION);
        } catch (IOException e) {
            throw new RuntimeException("Unable to write TestOps test cases", e);
        }
    }

    private void write(Object value, String fileName) throws IOException {
        Path file = outputDirectory.resolve(fileName);
        objectMapper.writeValue(file.toFile(), value);
    }
}
