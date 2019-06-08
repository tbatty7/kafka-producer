package com.battybuilds.kafkaproducer.config;

import org.apache.avro.Schema;

public class SchemaBuilder {

    public Schema createAvroHttpRequestSchema(){

        Schema clientIdentifier = org.apache.avro.SchemaBuilder.record("ClientIdentifier")
                .namespace("com.battybuilds.kafkaproducer.avro.model")
                .fields()
                .requiredString("hostName")
                .requiredString("ipAddress")
                .endRecord();

        Schema avroHttpRequest = org.apache.avro.SchemaBuilder.record("AvroHttpRequest").namespace("com.battybuilds.kafkaproducer.avro.model").fields()
                .requiredLong("requestTime")
                .name("clientIdentifier").type(clientIdentifier).noDefault()
                .name("employeeNames").type().array().items().stringType().arrayDefault(null)
                .endRecord();
        return avroHttpRequest;
    }
}
