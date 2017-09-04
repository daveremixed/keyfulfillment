package com.gonzobeans.keyfulfillment.exception;

/**
 * Created by Dave on 5/30/2017.
 */
public class ItemAlreadyExistsException extends IllegalArgumentException {
    public ItemAlreadyExistsException(String message) {
        super(message);
    }
}
