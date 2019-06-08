package com.battybuilds.kafkaproducer;

import com.battybuilds.kafkaproducer.avro.model.AvroHttpRequest;
import com.battybuilds.kafkaproducer.avro.model.ClientIdentifier;

import java.util.Arrays;

public class RequestBuilder {

    public static AvroHttpRequest createTestRequest() {
        ClientIdentifier clientIdentifier = ClientIdentifier.newBuilder()
                .setHostName("Hostess Twinkies")
                .setIpAddress("Ip Man lives in China?")
                .build();
        return AvroHttpRequest.newBuilder()
                .setClientIdentifier(clientIdentifier)
                .setEmployeeNames(Arrays.asList("Yohan", "Sebastian", "Bach"))
                .setRequestTime(3L)
                .build();
    }
}
