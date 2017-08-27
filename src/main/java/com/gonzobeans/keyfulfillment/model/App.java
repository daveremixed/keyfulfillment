package com.gonzobeans.keyfulfillment.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class App {
    private String name;
    private String description;
    private String secret;
    private CodeType codeType;
    private Integer codeSize;
    private boolean active;

    public App() {
        this.active = true;
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

    public boolean isActive() {
        return active;
    }

    public CodeType getCodeType() {
        return codeType;
    }

    public void setCodeType(CodeType codeType) {
        this.codeType = codeType;
    }

    public int getCodeSize() {
        return codeSize;
    }

    public void setCodeSize(int codeSize) {
        this.codeSize = codeSize;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
