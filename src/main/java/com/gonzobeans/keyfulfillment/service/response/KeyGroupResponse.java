package com.gonzobeans.keyfulfillment.service.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Created by Dave on 5/29/2017.
 */

public class KeyGroupResponse extends ServiceResponse {
    private String name;
    private String description;
    private String secret;

    public KeyGroupResponse(String name, String description) {
        this.name = name;
        this.description = description;
        this.success = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
