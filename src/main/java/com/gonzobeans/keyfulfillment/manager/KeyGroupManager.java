package com.gonzobeans.keyfulfillment.manager;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.gonzobeans.keyfulfillment.entity.KeyGroup;
import com.gonzobeans.keyfulfillment.exception.IllegalNameException;
import com.gonzobeans.keyfulfillment.exception.ItemAlreadyExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

import static com.gonzobeans.keyfulfillment.util.Constants.DYNAMODB_NAME_REGEX;
import static com.gonzobeans.keyfulfillment.util.Constants.INVALID_NAME_REGEX;

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

    public KeyGroup createKeyGroup(String name, String description)
            throws ItemAlreadyExistsException, IllegalNameException {
        KeyGroup keyGroup;

        // Validate name
        if (!name.matches(DYNAMODB_NAME_REGEX)) {
            throw new IllegalNameException("KeyGroup name: " + name + " is invalid. " + INVALID_NAME_REGEX);
        }

        //Check to see if it exists
        keyGroup = mapper.load(KeyGroup.class, name);
        if (keyGroup != null) {
            LOG.info("Found KeyGroup with ID: " + name);
            throw new ItemAlreadyExistsException("A KeyGroup with the name " + name + "already exists");
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
