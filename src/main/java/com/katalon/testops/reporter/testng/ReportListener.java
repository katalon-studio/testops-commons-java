package com.katalon.testops.reporter.testng;

import com.google.common.base.Joiner;
import com.katalon.testops.ReportLifecycle;
import com.katalon.testops.helper.GeneratorHelper;
import com.katalon.testops.helper.StringHelper;
import com.katalon.testops.model.Metadata;
import com.katalon.testops.model.Status;
import com.katalon.testops.model.TestResult;
import com.katalon.testops.model.TestSuite;
import org.testng.*;
import org.testng.annotations.Parameters;
import org.testng.xml.XmlTest;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.stream.Stream;

import static com.katalon.testops.core.Constants.TESTOPS_UUID_ATTR;
import static com.katalon.testops.helper.StringHelper.getErrorMessage;
import static com.katalon.testops.helper.StringHelper.getStackTraceAsString;

public class ReportListener implements ITestListener, IExecutionListener, ISuiteListener {

    private static final List<Class<?>> INJECTED_TYPES = Arrays.asList(
            ITestContext.class, ITestResult.class, XmlTest.class, Method.class, Object[].class
    );
    private final ReportLifecycle reportLifecycle;

    public ReportListener() {
        reportLifecycle = new ReportLifecycle();
    }

    private static String generateAndRegisterUuid(IAttributes iAttributes) {
        String uuid = GeneratorHelper.generateUniqueValue();
        iAttributes.setAttribute(TESTOPS_UUID_ATTR, uuid);
        return uuid;
    }

    private static String getOrCreateUuid(IAttributes iAttributes) {
        Object uuid = iAttributes.getAttribute(TESTOPS_UUID_ATTR);
        if (uuid == null) {
            return generateAndRegisterUuid(iAttributes);
        }
        return Objects.toString(uuid);
    }

    private static Map<String, String> getParameters(ITestNGMethod method, Object... parameters) {
        Map<String, String> result = new HashMap<>();

        Method reflectionMethod = method.getConstructorOrMethod().getMethod();
        Class<?>[] parameterTypes = reflectionMethod.getParameterTypes();

        if (parameterTypes.length != parameters.length) {
            return Collections.emptyMap();
        }

        String[] providedNames = Optional.ofNullable(reflectionMethod.getAnnotation(Parameters.class))
                .map(Parameters::value)
                .orElse(new String[]{});

        String[] reflectionNames = Stream.of(reflectionMethod.getParameters())
                .map(Parameter::getName)
                .toArray(String[]::new);

        int skippedCount = 0;
        for (int i = 0; i < parameterTypes.length; i++) {
            final Class<?> parameterType = parameterTypes[i];
            if (INJECTED_TYPES.contains(parameterType)) {
                skippedCount++;
                continue;
            }

            final int indexFromAnnotation = i - skippedCount;
            if (indexFromAnnotation < providedNames.length) {
                result.put(providedNames[indexFromAnnotation], StringHelper.toString(parameters[i]));
                continue;
            }

            if (i < reflectionNames.length) {
                result.put(reflectionNames[i], StringHelper.toString(parameters[i]));
            }
        }

        return result;
    }

    private static String getParentUuid(ITestResult result) {
        ISuite currentSuite = result.getTestContext().getSuite();
        return getOrCreateUuid(currentSuite);
    }

    private TestResult createTestResult(ITestResult result, Status status) {
        String uuid = GeneratorHelper.generateUniqueValue();

        TestResult testResult = new TestResult();
        testResult.setStatus(status);
        testResult.setUuid(uuid);
        testResult.setName(result.getMethod().getQualifiedName());
        testResult.setSuiteName(result.getTestContext().getSuite().getName());

        if (status.equals(Status.FAILED) || status.equals(Status.ERROR) || status.equals(Status.SKIPPED)) {
            final Throwable throwable = result.getThrowable();
            testResult.setErrorMessage(getErrorMessage(throwable));
            testResult.setStackTrace(getStackTraceAsString(throwable));
        }
        testResult.setParameters(getParameters(result.getMethod(), result.getParameters()));

        testResult.setStart(result.getStartMillis());
        testResult.setStop(result.getEndMillis());
        testResult.setDuration(result.getEndMillis() - result.getStartMillis());
        return testResult;
    }

    private Metadata createMetadata() {
        Metadata metadata = new Metadata();
        metadata.setFramework("testng");
        metadata.setLanguage("java");
        metadata.setVersion(getClass().getPackage().getImplementationVersion());
        return metadata;
    }

    @Override
    public void onExecutionStart() {
        reportLifecycle.startExecution();
        reportLifecycle.writeMetadata(createMetadata());
    }

    @Override
    public void onStart(ISuite suite) {
        System.out.println("onStart: " + suite.getName());

        String uuid = generateAndRegisterUuid(suite);

        TestSuite testSuite = new TestSuite();
        testSuite.setName(suite.getName());
        reportLifecycle.startSuite(testSuite, uuid);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println(new StringBuilder("onStart context: ")
                .append(context.getName())
                .append("|")
                .append("Current XML Test: ")
                .append(context.getCurrentXmlTest().getName())
                .append("|")
                .append("All methods: ")
                .append(Joiner.on(",").join(context.getAllTestMethods())));
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart: " + result.getMethod().getMethodName());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure: " + result.getMethod().getMethodName());
        TestResult testResult = createTestResult(result, Status.FAILED);
        testResult.setParentUuid(getParentUuid(result));
        reportLifecycle.stopTestCase(testResult);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped: " + result.getMethod().getMethodName());
        TestResult testResult = createTestResult(result, Status.SKIPPED);
        testResult.setParentUuid(getParentUuid(result));
        reportLifecycle.stopTestCase(testResult);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("onTestFailedButWithinSuccessPercentage: " + result.getMethod().getMethodName());
        TestResult testResult = createTestResult(result, Status.PASSED);
        testResult.setParentUuid(getParentUuid(result));
        reportLifecycle.stopTestCase(testResult);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("onTestFailedWithTimeout: " + result.getMethod().getMethodName());
        TestResult testResult = createTestResult(result, Status.ERROR);
        testResult.setParentUuid(getParentUuid(result));
        reportLifecycle.stopTestCase(testResult);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess: " + result.getMethod().getMethodName());
        TestResult testResult = createTestResult(result, Status.PASSED);
        testResult.setParentUuid(getParentUuid(result));
        reportLifecycle.stopTestCase(testResult);
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish context: " + context);
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("onFinish ISuite: " + suite.getName());
        String uuid = getOrCreateUuid(suite);
        reportLifecycle.stopTestSuite(uuid);
    }

    @Override
    public void onExecutionFinish() {
        reportLifecycle.writeTestResultsReport();
        reportLifecycle.writeTestSuitesReport();
        reportLifecycle.stopExecution();
        reportLifecycle.writeExecutionReport();
        reportLifecycle.upload();
    }
}
