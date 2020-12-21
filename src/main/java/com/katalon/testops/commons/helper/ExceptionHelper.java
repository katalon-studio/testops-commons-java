package com.katalon.testops.commons.helper;

import com.katalon.testops.commons.logger.Logger;

public class ExceptionHelper {

    private static final Logger logger = LogHelper.getLogger();

    public static <T> T wrap(Exception e) {
        logger.info("Rethrow exception: " + e.getClass().getName() + " " + e.getMessage());
        throw new IllegalStateException(e);
    }
}
