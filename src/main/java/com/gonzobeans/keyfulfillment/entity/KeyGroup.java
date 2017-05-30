package com.gonzobeans.keyfulfillment.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.UUID;

/**
 * Entity documenting the owner of key sets
 */
@DynamoDBTable(tableName="KeyGroup")
public class KeyGroup {
    private String name;
    private String description;
    private final String secret;
    private boolean active;

    public KeyGroup() {
        this.secret = UUID.randomUUID().toString().replaceAll("-", "");
        this.active = true;
    }

    @DynamoDBHashKey(attributeName="name")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBAttribute(attributeName="description")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @DynamoDBAttribute(attributeName="secret")
    public String getSecret() {
        return secret;
    }

    @DynamoDBAttribute(attributeName="secret")
    public boolean getActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}
