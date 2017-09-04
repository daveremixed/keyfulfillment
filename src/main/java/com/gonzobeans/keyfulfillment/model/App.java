package com.gonzobeans.keyfulfillment.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.MoreObjects;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class App {
    @Column(unique = true)
    private String name;
    private String description;
    private String secret;
    @Enumerated(EnumType.STRING)
    private CodeType codeType;
    private Integer codeSize;

    public App() {

    }

    public App(App app)  {
        this.name = app.getName();
        this.description = app.getDescription();
        this.secret = app.getSecret();
        this.codeType = app.getCodeType();
        this.codeSize = app.getCodeSize();
    }

    private App(Builder builder) {
        setName(builder.name);
        setDescription(builder.description);
        setSecret(builder.secret);
        setCodeType(builder.codeType);
        codeSize = builder.codeSize;
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

    public CodeType getCodeType() {
        return codeType;
    }

    public void setCodeType(CodeType codeType) {
        this.codeType = codeType;
    }

    public Integer getCodeSize() {
        return codeSize;
    }

    public void setCodeSize(int codeSize) {
        this.codeSize = codeSize;
    }

    public static final class Builder {
        private String name;
        private String description;
        private String secret;
        private CodeType codeType;
        private Integer codeSize;
        private boolean active;

        public Builder() {
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withDescription(String val) {
            description = val;
            return this;
        }

        public Builder withSecret(String val) {
            secret = val;
            return this;
        }

        public Builder withCodeType(CodeType val) {
            codeType = val;
            return this;
        }

        public Builder withCodeSize(Integer val) {
            codeSize = val;
            return this;
        }

        public App build() {
            return new App(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        App app = (App) o;

        if (name != null ? !name.equals(app.name) : app.name != null) return false;
        if (description != null ? !description.equals(app.description) : app.description != null) return false;
        if (secret != null ? !secret.equals(app.secret) : app.secret != null) return false;
        if (codeType != app.codeType) return false;
        return codeSize != null ? codeSize.equals(app.codeSize) : app.codeSize == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (secret != null ? secret.hashCode() : 0);
        result = 31 * result + (codeType != null ? codeType.hashCode() : 0);
        result = 31 * result + (codeSize != null ? codeSize.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("description", description)
                .add("secret", secret)
                .add("codeType", codeType)
                .add("codeSize", codeSize)
                .toString();
    }
}
