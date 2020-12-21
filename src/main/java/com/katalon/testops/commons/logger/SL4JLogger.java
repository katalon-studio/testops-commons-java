package com.katalon.testops.commons.logger;


public class SL4JLogger extends DefaultLogger {

  private final org.slf4j.Logger logger;

  public SL4JLogger(org.slf4j.Logger logger) {
    this.logger = logger;
  }

  @Override
  public void info(String message) {
    logger.info(message);
  }

  @Override
  public void debug(String message) {
    logger.debug(message);
  }

  @Override
  public void error(String message) {
    logger.error(message);
  }

  @Override
  public void error(Throwable throwable) {
    logger.error("", throwable);
  }

  @Override
  public void error(String message, Throwable throwable) {
    logger.error(message, throwable);
  }

}
