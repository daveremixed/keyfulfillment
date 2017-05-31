package com.gonzobeans.keyfulfillment.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Date;

/**
 * Created by Dave on 5/30/2017.
 */
@DynamoDBTable(tableName="Key")
public class Key {
    private String keyGroupName;
    private String id;
    private String keySetId;
    private Date dateCreated;
    private Date dateRedeemed;
    private Date expiration;
}
