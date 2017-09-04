package com.gonzobeans.keyfulfillment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.MoreObjects;

import java.time.ZonedDateTime;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Key {
    private String appName;
    private String value;
    private String keySetName;
    private KeyStatus keyStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private ZonedDateTime dateCreated;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private ZonedDateTime dateRedeemed;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private ZonedDateTime expiration;

    public Key () {

    }

    public Key(Key key) {
        this.appName = key.getAppName();
        this.value = key.getValue();
        this.keySetName = key.getKeySetName();
        this.dateCreated = key.getDateCreated();
        this.dateRedeemed = key.getDateRedeemed();
        this.expiration = key.getExpiration();
        this.keyStatus = key.getKeyStatus();
    }

    private Key(Builder builder) {
        setAppName(builder.appName);
        setValue(builder.value);
        setKeySetName(builder.keySetName);
        setKeyStatus(builder.keyStatus);
        setDateCreated(builder.dateCreated);
        setDateRedeemed(builder.dateRedeemed);
        setExpiration(builder.expiration);
    }

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


    public static final class Builder {
        private String appName;
        private String value;
        private String keySetName;
        private KeyStatus keyStatus;
        private ZonedDateTime dateCreated;
        private ZonedDateTime dateRedeemed;
        private ZonedDateTime expiration;

        public Builder() {
        }

        public Builder withAppName(String val) {
            appName = val;
            return this;
        }

        public Builder withValue(String val) {
            value = val;
            return this;
        }

        public Builder withKeySetName(String val) {
            keySetName = val;
            return this;
        }

        public Builder withKeyStatus(KeyStatus val) {
            keyStatus = val;
            return this;
        }

        public Builder withDateCreated(ZonedDateTime val) {
            dateCreated = val;
            return this;
        }

        public Builder withDateRedeemed(ZonedDateTime val) {
            dateRedeemed = val;
            return this;
        }

        public Builder withExpiration(ZonedDateTime val) {
            expiration = val;
            return this;
        }

        public Key build() {
            return new Key(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Key key = (Key) o;

        if (appName != null ? !appName.equals(key.appName) : key.appName != null) return false;
        if (value != null ? !value.equals(key.value) : key.value != null) return false;
        if (keySetName != null ? !keySetName.equals(key.keySetName) : key.keySetName != null) return false;
        if (keyStatus != key.keyStatus) return false;
        if (dateCreated != null ? !dateCreated.equals(key.dateCreated) : key.dateCreated != null) return false;
        if (dateRedeemed != null ? !dateRedeemed.equals(key.dateRedeemed) : key.dateRedeemed != null) return false;
        return expiration != null ? expiration.equals(key.expiration) : key.expiration == null;
    }

    @Override
    public int hashCode() {
        int result = appName != null ? appName.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + (keySetName != null ? keySetName.hashCode() : 0);
        result = 31 * result + (keyStatus != null ? keyStatus.hashCode() : 0);
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (dateRedeemed != null ? dateRedeemed.hashCode() : 0);
        result = 31 * result + (expiration != null ? expiration.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("appName", appName)
                .add("value", value)
                .add("keySetName", keySetName)
                .add("keyStatus", keyStatus)
                .add("dateCreated", dateCreated)
                .add("dateRedeemed", dateRedeemed)
                .add("expiration", expiration)
                .toString();
    }
}
