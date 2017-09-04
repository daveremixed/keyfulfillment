package com.gonzobeans.keyfulfillment.model;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum KeyStatus {
    AVAILABLE, IN_FLIGHT, REDEEMED, REVOKED, ANYSTATUS;

    @JsonCreator
    public static KeyStatus create(String value) {
        return  KeyStatus.valueOf(value.toUpperCase());
    }
}
