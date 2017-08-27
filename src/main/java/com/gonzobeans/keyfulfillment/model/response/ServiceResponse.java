package com.gonzobeans.keyfulfillment.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by Dave on 5/29/2017.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class ServiceResponse {
    protected boolean success;

    public boolean getSuccess() {
        return success;
    }

}
