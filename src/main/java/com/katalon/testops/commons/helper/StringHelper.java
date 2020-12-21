package com.katalon.testops.commons.helper;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class StringHelper {

    public static String toString(final Object object) {
        try {
            if (Objects.nonNull(object) && object.getClass().isArray()) {
                if (object instanceof Object[]) {
                    return Arrays.toString((Object[]) object);
                } else if (object instanceof long[]) {
                    return Arrays.toString((long[]) object);
                } else if (object instanceof short[]) {
                    return Arrays.toString((short[]) object);
                } else if (object instanceof int[]) {
                    return Arrays.toString((int[]) object);
                } else if (object instanceof char[]) {
                    return Arrays.toString((char[]) object);
                } else if (object instanceof double[]) {
                    return Arrays.toString((double[]) object);
                } else if (object instanceof float[]) {
                    return Arrays.toString((float[]) object);
                } else if (object instanceof boolean[]) {
                    return Arrays.toString((boolean[]) object);
                } else if (object instanceof byte[]) {
                    return "<BINARY>";
                }
            }
            return Objects.toString(object);
        } catch (Exception e) {
            ExceptionHelper.wrap(e);
            return null;
        }
    }

    public static String getStackTraceAsString(final Throwable throwable) {
        final StringWriter stringWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static String getErrorMessage(final Throwable throwable) {
        return Optional.ofNullable(throwable.getMessage())
                .orElse(throwable.getClass().getName());
    }
}
