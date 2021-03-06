package com.katalon.testops.commons;

import com.katalon.testops.commons.configuration.Configuration;
import com.katalon.testops.commons.configuration.ConfigurationCreator;
import com.katalon.testops.commons.configuration.TestOpsConfigurationCreator;
import com.katalon.testops.commons.configuration.proxy.ProxyInformation;
import com.katalon.testops.commons.generator.ReportGenerator;
import com.katalon.testops.commons.generator.TestOpsReportGenerator;
import com.katalon.testops.commons.helper.GeneratorHelper;
import com.katalon.testops.commons.helper.LogHelper;
import com.katalon.testops.commons.model.*;
import com.katalon.testops.commons.uploader.ReportUploader;
import com.katalon.testops.commons.uploader.TestOpsReportUploader;
import org.slf4j.Logger;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedQueue;

import static com.katalon.testops.commons.helper.StringHelper.getHostName;
import static com.katalon.testops.commons.helper.StringHelper.getThreadName;

public class ReportLifecycle {

    private static final Logger logger = LogHelper.getLogger();

    private final ReportStorage reportStorage;

    private final ReportGenerator reportGenerator;

    private final ReportUploader reportUploader;

    private final Collection<TestResult> testResults = new ConcurrentLinkedQueue<>();

    private final Collection<TestSuite> suites = new ConcurrentLinkedQueue<>();

    private final ThreadLocal<String> currentTestResult = ThreadLocal.withInitial(GeneratorHelper::generateUniqueValue);

    private String currentExecution = null;

    public ReportLifecycle() {
        ConfigurationCreator configurationCreator = new TestOpsConfigurationCreator();
        Configuration configuration = configurationCreator.createConfiguration();
        logger.info("--------------- TestOps Configuration --------------");
        logger.info("Server URL: " + configuration.getServerUrl());
        logger.info("Project ID: " + configuration.getProjectId());
        logger.info("API Key: {}", configuration.getApiKey() != null);

        ProxyInformation proxyInformation = configuration.getProxyInformation();
        if (proxyInformation != null) {
            logger.info("Proxy Option: " + proxyInformation.getProxyOption());
            logger.info("Proxy Server Type: " + proxyInformation.getProxyServerType());
            logger.info("Proxy Host: " + proxyInformation.getHost());
            logger.info("Proxy Port: " + proxyInformation.getPort());
            logger.info("Proxy Username: " + proxyInformation.getUsername());
            logger.info("Proxy Password: {}",  proxyInformation.getPassword() != null);
        }
        logger.info("--------------- TestOps Configuration --------------");
        this.reportStorage = new ReportStorage();
        this.reportGenerator = createDefaultGenerator(configuration);
        this.reportUploader = createDefaultUploader(configuration);
    }

    public ReportLifecycle(ReportGenerator reportGenerator, ReportUploader reportUploader) {
        this.reportStorage = new ReportStorage();
        this.reportGenerator = reportGenerator;
        this.reportUploader = reportUploader;
    }

    private static ReportGenerator createDefaultGenerator(Configuration configuration) {
        return new TestOpsReportGenerator(configuration);
    }

    private static ReportUploader createDefaultUploader(Configuration configuration) {
        return new TestOpsReportUploader(configuration);
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
        assignNewExecution();
        Execution execution = new Execution();
        execution.setStart(System.currentTimeMillis());
        execution.setUuid(currentExecution);
        reportStorage.put(execution.getUuid(), execution);
    }

    public void startSuite(TestSuite testSuite, String uuid) {
        testSuite.setUuid(uuid);
        getCurrentExecution().ifPresent(execution -> testSuite.setParentUuid(execution.getUuid()));
        testSuite.setStart(System.currentTimeMillis());
        reportStorage.put(testSuite.getUuid(), testSuite);
    }

    public void startTestCase() {
        TestResult testResult = new TestResult();
        testResult.setUuid(currentTestResult.get());
        testResult.setStart(System.currentTimeMillis());
        reportStorage.put(testResult.getUuid(), testResult);
    }

    public void stopTestCase(TestResult testResult) {
        Optional<TestResult> optionalRunningTestResult = getCurrentRunningTestResult();
        optionalRunningTestResult.ifPresent(runningTestResult -> {
            if (Objects.isNull(testResult.getStart())) {
                testResult.setStart(runningTestResult.getStart());
            }
            if (Objects.isNull(testResult.getStop())) {
                testResult.setStop(System.currentTimeMillis());
            }
            if (Objects.isNull(testResult.getDuration())) {
                testResult.setDuration(testResult.getStop() - testResult.getStart());
            }
            clearCurrentTestResult();
        });
        testResult.setThread(getThreadName());
        testResult.setHost(getHostName());
        testResults.add(testResult);
    }

    public void stopTestSuite(String uuid) {
        Optional<TestSuite> optionalTestSuite = reportStorage.get(uuid, TestSuite.class);
        optionalTestSuite.ifPresent(testSuite -> {
            testSuite.setStop(System.currentTimeMillis());
            testSuite.setDuration(testSuite.getStop() - testSuite.getStart());
            testSuite.setThread(getThreadName());
            testSuite.setHost(getHostName());
            suites.add(reportStorage.put(uuid, testSuite));
        });
    }

    public void stopExecution() {
        Optional<Execution> optionalExecution = getCurrentExecution();
        optionalExecution.ifPresent(execution -> {
            execution.setStop(System.currentTimeMillis());
            execution.setDuration(execution.getStop() - execution.getStart());
            execution.setStatus(getExecutionStatusFromTestResults(testResults));
            execution.setThread(getThreadName());
            execution.setHost(getHostName());
            reportStorage.put(execution.getUuid(), execution);
        });
    }

    public void writeExecutionReport() {
        Optional<Execution> optionalExecution = getCurrentExecution();
        optionalExecution.ifPresent(reportGenerator::write);
        reportStorage.remove(currentExecution);
    }

    public void writeTestSuitesReport() {
        TestSuites testSuites = createTestSuites(suites);
        reportGenerator.write(testSuites);
    }

    public void writeTestResultsReport() {
        TestResults testResults = createTestCases(this.testResults);
        reportGenerator.write(testResults);
    }

    public void writeMetadata(Metadata metadata) {
        reportGenerator.write(metadata);
    }

    public void upload() {
        reportUploader.upload();
    }

    public void reset() {
        clearTestResults();
        clearSuites();
        resetCurrentExecution();
    }

    private Optional<Execution> getCurrentExecution() {
        return reportStorage.get(currentExecution, Execution.class);
    }

    private Optional<TestResult> getCurrentRunningTestResult() {
        return reportStorage.get(currentTestResult.get(), TestResult.class);
    }

    private Status getExecutionStatusFromTestResults(Collection<TestResult> testResults) {
        boolean failed = testResults.stream().map(TestResult::getStatus).anyMatch(Status::isFailed);
        if (failed) {
            return Status.FAILED;
        } else {
            return Status.PASSED;
        }
    }

    private void assignNewExecution() {
        currentExecution = GeneratorHelper.generateUniqueValue();
    }

    private void resetCurrentExecution() {
        currentExecution = null;
    }

    private void clearCurrentTestResult() {
        reportStorage.remove(currentTestResult.get());
        currentTestResult.remove();
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
