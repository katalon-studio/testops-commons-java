package com.katalon.testops;

import com.katalon.testops.generator.ReportGenerator;
import com.katalon.testops.generator.TestOpsReportGenerator;
import com.katalon.testops.helper.GeneratorHelper;
import com.katalon.testops.helper.ParameterHelper;
import com.katalon.testops.model.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedQueue;

import static com.katalon.testops.core.Constants.TESTOPS_RESULTS_DIRECTORY;
import static com.katalon.testops.core.Constants.TESTOPS_RESULTS_DIRECTORY_DEFAULT;

public class ReportLifecycle {

    private final ReportStorage reportStorage;

    private final ReportGenerator reportGenerator;

    private final ThreadLocal<String> currentExecution = ThreadLocal.withInitial(GeneratorHelper::generateUniqueValue);

    private final Collection<TestResult> testResults = new ConcurrentLinkedQueue<>();

    private final Collection<TestSuite> suites = new ConcurrentLinkedQueue<>();

    public ReportLifecycle() {
        this(getDefaultWriter());
    }

    public ReportLifecycle(ReportGenerator reportGenerator) {
        this.reportStorage = new ReportStorage();
        this.reportGenerator = reportGenerator;
    }

    private static ReportGenerator getDefaultWriter() {
        String outputDirectoryParam = Optional.ofNullable(ParameterHelper.get(TESTOPS_RESULTS_DIRECTORY))
                .orElse(TESTOPS_RESULTS_DIRECTORY_DEFAULT);
        Path outputDirectory = Paths.get(outputDirectoryParam);
        return new TestOpsReportGenerator(outputDirectory);
    }

    private static TestResults createTestCases(Collection<TestResult> testResults) {
        TestResults testCases = new TestResults();
        testCases.setResults(testResults);
        return testCases;
    }

    private static TestSuites createTestSuites(Collection<TestSuite> suites) {
        TestSuites testSuites = new TestSuites();
        testSuites.setSuites(suites);
        return testSuites;
    }

    public void startExecution() {
        Execution execution = new Execution();
        execution.setStart(System.currentTimeMillis());
        execution.setUuid(currentExecution.get());
        reportStorage.put(execution.getUuid(), execution);
    }

    public void startSuite(TestSuite testSuite, String uuid) {
        testSuite.setUuid(uuid);
        getCurrentExecution().ifPresent(execution -> {
            testSuite.setParentUuid(execution.getUuid());
        });
        testSuite.setStart(System.currentTimeMillis());
        reportStorage.put(testSuite.getUuid(), testSuite);
    }

    public void stopTestCase(TestResult testResult) {
        testResults.add(testResult);
    }

    public void stopTestSuite(String uuid) {
        Optional<TestSuite> optionalTestSuite = reportStorage.get(uuid, TestSuite.class);
        optionalTestSuite.ifPresent(testSuite -> {
            testSuite.setStop(System.currentTimeMillis());
            testSuite.setDuration(testSuite.getStop() - testSuite.getStart());
            suites.add(reportStorage.put(uuid, testSuite));
        });
    }

    public void stopExecution() {
        Optional<Execution> optionalExecution = getCurrentExecution();
        optionalExecution.ifPresent(execution -> {
            execution.setStop(System.currentTimeMillis());
            execution.setDuration(execution.getStop() - execution.getStart());
            execution.setStatus(getExecutionStatusFromTestResults(testResults));
            reportStorage.put(execution.getUuid(), execution);
        });
    }

    public void writeExecutionReport() {
        Optional<Execution> optionalExecution = getCurrentExecution();
        optionalExecution.ifPresent(reportGenerator::write);
        reportStorage.remove(currentExecution.get());
        currentExecution.remove();
    }

    public void writeTestSuitesReport() {
        TestSuites testSuites = createTestSuites(suites);
        reportGenerator.write(testSuites);
        clearSuites();
    }

    public void writeTestResultsReport() {
        TestResults testResults = createTestCases(this.testResults);
        reportGenerator.write(testResults);
        clearTestResults();
    }

    public void writeMetadata(Metadata metadata) {
        reportGenerator.write(metadata);
    }

    private Optional<Execution> getCurrentExecution() {
        return reportStorage.get(currentExecution.get(), Execution.class);
    }

    private Status getExecutionStatusFromTestResults(Collection<TestResult> testResults) {
        boolean failed = testResults.stream().map(TestResult::getStatus).anyMatch(Status::isFailed);
        if (failed) {
            return Status.FAILED;
        } else {
            return Status.PASSED;
        }
    }

    private void clearSuites() {
        suites.stream().map(TestSuite::getUuid).forEach(reportStorage::remove);
        suites.clear();
    }

    private void clearTestResults() {
        testResults.stream().map(TestResult::getUuid).forEach(reportStorage::remove);
        testResults.clear();
    }
}
