package com.gonzobeans.keyfulfillment.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Date;

/**
 * KeySets contain parameters for getting and distributing keys
 */
@DynamoDBTable(tableName="KeyGroup")
public class KeySet {
    private final String keyGroupName;
    private final String id;
    private Date validAfterDate;
    private Date expirationDate;
    private int codesUsed;
    private int maxCodes;
    private CodeType codeType;
    private int codeSize;
    private boolean active;

    public KeySet(String  keyGroupName, String id) {
        this.keyGroupName = keyGroupName;
        this.id = id;
        this.active = true;
    }

    @DynamoDBHashKey(attributeName="keyGroupName")
    public String getKeyGroupName() {
        return keyGroupName;
    }

    @DynamoDBRangeKey(attributeName="id")
    public String getId() {
        return id;
    }

    @DynamoDBAttribute(attributeName="validAfterDate")
    public Date getValidAfterDate() {
        return validAfterDate;
    }
    public void setValidAfterDate(Date validAfterDate) {
        this.validAfterDate = validAfterDate;
    }

    @DynamoDBAttribute(attributeName="expirationDate")
    public Date getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @DynamoDBAttribute(attributeName="codesUsed")
    public int getCodesUsed() {
        return codesUsed;
    }
    public void setCodesUsed(int codesUsed) {
        this.codesUsed = codesUsed;
    }

    @DynamoDBAttribute(attributeName="maxCodes")
    public int getMaxCodes() {
        return maxCodes;
    }
    public void setMaxCodes(int maxCodes) {
        this.maxCodes = maxCodes;
    }

    @DynamoDBAttribute(attributeName="codeType")
    public CodeType getCodeType() {
        return codeType;
    }
    public void setCodeType(CodeType codeType) {
        this.codeType = codeType;
    }

    @DynamoDBAttribute(attributeName="codeSize")
    public int getCodeSize() {
        return codeSize;
    }
    public void setCodeSize(int codeSize) {
        this.codeSize = codeSize;
    }

    @DynamoDBAttribute(attributeName="active")
    public boolean getActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}
