package com.gonzobeans.keyfulfillment.manager;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Dave on 5/29/2017.
 */
public class KeyGroupManagerTest {

    @Test
    public void testme() {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2"))
                .withCredentials(new ProfileCredentialsProvider("myProfile"))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        String tableName = "KeyGroup";

        try {
            System.out.println("Attempting to create table; please wait...");
            CreateTableRequest request = new CreateTableRequest(tableName,
                    Arrays.asList(new KeySchemaElement("name", KeyType.HASH)));
            Table table = dynamoDB.createTable(request);
            table.waitForActive();
            System.out.println("Success.  Table status: " + table.getDescription().getTableStatus());

        } catch (Exception e) {
            System.err.println("Unable to create table: ");
            System.err.println(e.getMessage());
        }
    }

}
