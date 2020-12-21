package com.katalon.testops.commons.logger;

public interface Logger {

    void info(String message);

    void debug(String message);

    void error(String message);

    void error(Throwable throwable);

    void error(String errorMessage, Throwable throwable);
}
