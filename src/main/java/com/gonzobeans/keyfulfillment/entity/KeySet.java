package com.gonzobeans.keyfulfillment.entity;

import javax.persistence.Entity;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * KeySets contain parameters for getting and distributing keys
 */
@Entity
public class KeySet {
    private String name;
    private String appName;
    private ZonedDateTime created;
    private ZonedDateTime validAfterDate;
    private ZonedDateTime expirationDate;
    private int codesUsed;
    private int maxCodes;
    private boolean active;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getCreated() {
        return created;
    }

    public void setCreated(ZonedDateTime created) {
        this.created = created;
    }

    public ZonedDateTime getValidAfterDate() {
        return validAfterDate;
    }

    public void setValidAfterDate(ZonedDateTime validAfterDate) {
        this.validAfterDate = validAfterDate;
    }

    public ZonedDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(ZonedDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCodesUsed() {
        return codesUsed;
    }

    public void setCodesUsed(int codesUsed) {
        this.codesUsed = codesUsed;
    }

    public int getMaxCodes() {
        return maxCodes;
    }

    public void setMaxCodes(int maxCodes) {
        this.maxCodes = maxCodes;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
