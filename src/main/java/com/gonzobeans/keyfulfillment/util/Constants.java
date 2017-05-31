package com.gonzobeans.keyfulfillment.util;

/**
 * Created by Dave on 5/30/2017.
 */
public class Constants {
    public static final String DYNAMODB_NAME_REGEX = "^[a-zA-Z0-9-_.]{3,32}$";
    public static final String INVALID_NAME_REGEX = "Argument must be between 3-32 characters and contain only alphanumeric, spaces, periods, and dashes.";
}
