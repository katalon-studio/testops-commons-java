package com.katalon.testops.commons.helper;

import com.katalon.testops.commons.logger.DefaultLogger;
import com.katalon.testops.commons.logger.Logger;

public class LogHelper {

    public static Logger getLogger() {
        return new DefaultLogger();
    }
}
