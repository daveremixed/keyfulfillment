package com.gonzobeans.keyfulfillment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.ZonedDateTime;

/**
 * KeySets contain parameters for getting and distributing keys
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KeySet {
    private String name;
    private String appName;
    private ZonedDateTime created;
    private ZonedDateTime validAfterDate;
    private ZonedDateTime expirationDate;
    private Integer codesCreated;
    private Integer codesUsed;
    private Integer maxCodes;

    public KeySet() {

    }

    private KeySet(Builder builder) {
        setName(builder.name);
        setAppName(builder.appName);
        setCreated(builder.created);
        setValidAfterDate(builder.validAfterDate);
        setExpirationDate(builder.expirationDate);
        setCodesCreated(builder.codesCreated);
        setCodesUsed(builder.codesUsed);
        setMaxCodes(builder.maxCodes);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZonedDateTime getCreated() {
        return created;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
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

    public Integer getCodesCreated() {
        return codesCreated;
    }

    public void setCodesCreated(Integer codesCreated) {
        this.codesCreated = codesCreated;
    }

    public int getCodesUsed() {
        return codesUsed;
    }

    public void setCodesUsed(int codesUsed) {
        this.codesUsed = codesUsed;
    }

    public void setCodesUsed(Integer codesUsed) {
        this.codesUsed = codesUsed;
    }

    public Integer getMaxCodes() {
        return maxCodes;
    }

    public void setMaxCodes(Integer maxCodes) {
        this.maxCodes = maxCodes;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KeySet keySet = (KeySet) o;

        if (name != null ? !name.equals(keySet.name) : keySet.name != null) return false;
        if (appName != null ? !appName.equals(keySet.appName) : keySet.appName != null) return false;
        if (created != null ? !created.equals(keySet.created) : keySet.created != null) return false;
        if (validAfterDate != null ? !validAfterDate.equals(keySet.validAfterDate) : keySet.validAfterDate != null)
            return false;
        if (expirationDate != null ? !expirationDate.equals(keySet.expirationDate) : keySet.expirationDate != null)
            return false;
        if (codesCreated != null ? !codesCreated.equals(keySet.codesCreated) : keySet.codesCreated != null)
            return false;
        if (codesUsed != null ? !codesUsed.equals(keySet.codesUsed) : keySet.codesUsed != null) return false;
        return maxCodes != null ? maxCodes.equals(keySet.maxCodes) : keySet.maxCodes == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (appName != null ? appName.hashCode() : 0);
        result = 31 * result + (created != null ? created.hashCode() : 0);
        result = 31 * result + (validAfterDate != null ? validAfterDate.hashCode() : 0);
        result = 31 * result + (expirationDate != null ? expirationDate.hashCode() : 0);
        result = 31 * result + (codesCreated != null ? codesCreated.hashCode() : 0);
        result = 31 * result + (codesUsed != null ? codesUsed.hashCode() : 0);
        result = 31 * result + (maxCodes != null ? maxCodes.hashCode() : 0);
        return result;
    }

    public static final class Builder {
        private String name;
        private String appName;
        private ZonedDateTime created;
        private ZonedDateTime validAfterDate;
        private ZonedDateTime expirationDate;
        private Integer codesCreated;
        private Integer codesUsed;
        private Integer maxCodes;

        public Builder() {
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withAppName(String val) {
            appName = val;
            return this;
        }

        public Builder withCreated(ZonedDateTime val) {
            created = val;
            return this;
        }

        public Builder withValidAfterDate(ZonedDateTime val) {
            validAfterDate = val;
            return this;
        }

        public Builder withExpirationDate(ZonedDateTime val) {
            expirationDate = val;
            return this;
        }

        public Builder withCodesCreated(Integer val) {
            codesCreated = val;
            return this;
        }

        public Builder withCodesUsed(Integer val) {
            codesUsed = val;
            return this;
        }

        public Builder withMaxCodes(Integer val) {
            maxCodes = val;
            return this;
        }

        public KeySet build() {
            return new KeySet(this);
        }
    }
}
