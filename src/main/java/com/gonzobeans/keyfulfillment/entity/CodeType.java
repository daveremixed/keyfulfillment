package com.gonzobeans.keyfulfillment.entity;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum CodeType {
    ALPHA, ALPHACAPS, ALPHANUMERIC, ALPHANUMERIC_CAPS, NUMERIC;

    @JsonCreator
    public static CodeType create(String value) {
        return CodeType.valueOf(value.toUpperCase());
    }
}
