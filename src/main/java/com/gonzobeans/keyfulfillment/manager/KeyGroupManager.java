package com.gonzobeans.keyfulfillment.manager;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.gonzobeans.keyfulfillment.entity.KeyGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * Created by Dave on 5/29/2017.
 */
public class KeyGroupManager {

    private AmazonDynamoDB client;
    private DynamoDBMapper mapper;
    private static final Logger LOG = LoggerFactory.getLogger(KeyGroupManager.class);

    public KeyGroupManager() {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2"))
                .withCredentials(new ProfileCredentialsProvider("default"))
                .build();
        mapper = new DynamoDBMapper(client);
    }

    public KeyGroup createKeyGroup(String name, String description) {
        KeyGroup keyGroup;

        // Validate name

        //Check to see if it exists
        keyGroup = mapper.load(KeyGroup.class, name);
        if (keyGroup != null) {
            LOG.info("Found KeyGroup with ID: " + name);
        } else {
            // Create KeyGroup
            LOG.info("Creating KeyGroup with name: " + name);
            keyGroup = new KeyGroup(name, description);
            keyGroup.setSecret(UUID.randomUUID().toString().replaceAll("-", ""));

            // Create in DB
            mapper.save(keyGroup);
            // Return Response
        }

        return keyGroup;
    }
}
