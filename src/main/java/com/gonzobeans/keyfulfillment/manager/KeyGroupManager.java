package com.gonzobeans.keyfulfillment.manager;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.gonzobeans.keyfulfillment.entity.KeyGroup;

/**
 * Created by Dave on 5/29/2017.
 */
public class KeyGroupManager {

    private AmazonDynamoDB client;
    private DynamoDBMapper mapper;

    public KeyGroupManager() {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2"))
                .build();
        mapper = new DynamoDBMapper(client);
    }

    public KeyGroup createKeyGroup(String name, String description) {
        // Validate name

        // Create KeyGroup
        KeyGroup keyGroup = new KeyGroup(name, description);

        // Create in DB

        // Return Response
        return keyGroup;
    }
}
