package com.gonzobeans.keyfulfillment.service.response;

/**
 * Created by Dave on 5/28/2017.
 */
public class PingResponse extends ServiceResponse {

    public PingResponse() {
        this.success = true;
    }

    public String getContent() {
        return "Pong!";
    }

}
