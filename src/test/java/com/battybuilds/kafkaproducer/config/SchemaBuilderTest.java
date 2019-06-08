package com.battybuilds.kafkaproducer.config;

import org.junit.Test;

import static org.junit.Assert.*;

public class SchemaBuilderTest {

    @Test
    public void createAvroHttpRequestSchema() {
        SchemaBuilder avroSchemaBuilder = new SchemaBuilder();
        String schema = avroSchemaBuilder.createAvroHttpRequestSchema().toString();
        System.out.println(schema);
        assertNotNull(schema);
    }
}