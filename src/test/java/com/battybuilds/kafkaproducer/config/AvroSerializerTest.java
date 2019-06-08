package com.battybuilds.kafkaproducer.config;

import com.battybuilds.kafkaproducer.RequestBuilder;
import com.battybuilds.kafkaproducer.avro.model.AvroHttpRequest;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AvroSerializerTest {

    private AvroSerializer avroSerializer = new AvroSerializer();

    @Test
    public void serializesAvroClass() {
        AvroHttpRequest request = RequestBuilder.createTestRequest();

        byte[] bytes = avroSerializer.serialize(request);

        String result = new String(bytes);
        assertTrue(result.contains(request.getClientIdentifier().getHostName()));
    }
}
