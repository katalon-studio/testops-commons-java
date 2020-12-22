package com.katalon.testops.commons.helper;

import org.slf4j.Logger;

public class ExceptionHelper {

    private static final Logger logger = LogHelper.getLogger();

    public static <T> T wrap(Exception e) {
        logger.info("Rethrow exception: " + e.getClass().getName() + " " + e.getMessage());
        throw new IllegalStateException(e);
    }
}
