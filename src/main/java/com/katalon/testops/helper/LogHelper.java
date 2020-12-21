package com.katalon.testops.helper;

import com.katalon.testops.logger.DefaultLogger;
import com.katalon.testops.logger.Logger;

public class LogHelper {

    public static Logger getLogger() {
        return new DefaultLogger();
    }
}
