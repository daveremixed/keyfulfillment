package com.gonzobeans.keyfulfillment.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum KeyStatus {
    ACTIVE, REVOKED;

    @JsonCreator
    public static KeyStatus create(String value) {
        return  KeyStatus.valueOf(value.toUpperCase());
    }
}
