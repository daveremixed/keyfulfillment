package com.gonzobeans.keyfulfillment.setup;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dave on 5/30/2017.
 */
public class DynamoDb {

    @Test
    public void createTables() {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2"))
                .withCredentials(new ProfileCredentialsProvider("default"))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        String tableName = "KeyGroup";

        try {
            System.out.println("Attempting to create table; please wait...");

            List<AttributeDefinition> attributeDefinitions= new ArrayList<>();
            attributeDefinitions.add(new AttributeDefinition().withAttributeName("name").withAttributeType("S"));

            List<KeySchemaElement> keySchema = new ArrayList<>();
            keySchema.add(new KeySchemaElement().withAttributeName("name").withKeyType(KeyType.HASH));

            CreateTableRequest request = new CreateTableRequest()
                    .withTableName("KeyGroup")
                    .withKeySchema(keySchema)
                    .withAttributeDefinitions(attributeDefinitions)
                    .withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(5L).withWriteCapacityUnits(5L));
            Table table = dynamoDB.createTable(request);
            table.waitForActive();
            System.out.println("Success.  Table status: " + table.getDescription().getTableStatus());

        } catch (Exception e) {
            System.err.println("Unable to create table: ");
            System.err.println(e.getMessage());
        }
    }
}
