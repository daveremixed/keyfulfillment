package com.gonzobeans.keyfulfillment.model.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Dave on 5/29/2017.
 */
public class ErrorResponse extends ResourceSupport {
    private String error;
    private String details;

    @JsonCreator
    public ErrorResponse(Exception ex) {
        this.error = ex.getMessage();
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
