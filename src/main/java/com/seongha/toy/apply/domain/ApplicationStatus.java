package com.seongha.toy.apply.domain;

import java.util.Arrays;

public enum ApplicationStatus {
    WAITING,
    PASSED,
    FAILED;

    public static ApplicationStatus find(String status) {
        return Arrays.stream(ApplicationStatus.values())
            .filter(applicationStatus -> applicationStatus.name().equals(status))
            .findAny()
            .orElseThrow(() -> new IllegalArgumentException("ApplicationStatus not found, input = " + status));
    }
}
