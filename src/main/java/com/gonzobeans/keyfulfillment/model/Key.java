package com.gonzobeans.keyfulfillment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.ZonedDateTime;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Key {
    private String appName;
    private String value;
    private String keySetName;
    private KeyStatus keyStatus;
    private ZonedDateTime dateCreated;
    private ZonedDateTime dateRedeemed;
    private ZonedDateTime expiration;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getKeySetName() {
        return keySetName;
    }

    public void setKeySetName(String keySetName) {
        this.keySetName = keySetName;
    }

    public KeyStatus getKeyStatus() {
        return keyStatus;
    }

    public void setKeyStatus(KeyStatus keyStatus) {
        this.keyStatus = keyStatus;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public ZonedDateTime getDateRedeemed() {
        return dateRedeemed;
    }

    public void setDateRedeemed(ZonedDateTime dateRedeemed) {
        this.dateRedeemed = dateRedeemed;
    }

    public ZonedDateTime getExpiration() {
        return expiration;
    }

    public void setExpiration(ZonedDateTime expiration) {
        this.expiration = expiration;
    }
}
