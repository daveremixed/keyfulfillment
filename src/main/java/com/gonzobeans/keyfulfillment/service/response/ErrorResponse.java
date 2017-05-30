package com.gonzobeans.keyfulfillment.service.response;

/**
 * Created by Dave on 5/29/2017.
 */
public class ErrorResponse extends ServiceResponse {
    private String error;
    private String details;

    public ErrorResponse() {
        this.success = false;
    }

    public ErrorResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
