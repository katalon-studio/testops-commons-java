package com.katalon.testops.model;

import java.util.EnumSet;
import java.util.Set;

public enum Status {
    PASSED, FAILED, INCOMPLETE, ERROR, SKIPPED;

    private static final Set<Status> FAILED_STATUSES = EnumSet.of(FAILED, INCOMPLETE, ERROR);

    public boolean isFailed() {
        return FAILED_STATUSES.contains(this);
    }
}
