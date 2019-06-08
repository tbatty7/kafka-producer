package com.battybuilds.kafkaproducer;

import com.battybuilds.kafkaproducer.avro.model.AvroHttpRequest;
import com.battybuilds.kafkaproducer.avro.model.ClientIdentifier;
import com.battybuilds.kafkaproducer.config.AvroSerializer;
import com.battybuilds.kafkaproducer.config.MyMessageChannels;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@EnableBinding(MyMessageChannels.class)
public class Producer {

    private final MyMessageChannels myMessageChannels;
    private AvroSerializer serializer;

    public Producer(MyMessageChannels myMessageChannels, AvroSerializer serializer) {
        this.myMessageChannels = myMessageChannels;
        this.serializer = serializer;
    }

    @GetMapping("/")
    public String sendMessage() {
        AvroHttpRequest request = createAvroHttpRequest();
        byte[] serializedRequest = serializer.serialize(request);
        myMessageChannels.outputChannel().send(MessageBuilder.withPayload(serializedRequest).build());

        return "Avro message sent with binary serialization!";
    }

    private AvroHttpRequest createAvroHttpRequest() {
        ClientIdentifier clientIdentifier = ClientIdentifier.newBuilder()
                .setHostName("hostName")
                .setIpAddress("127.0.0.1")
                .build();

        return AvroHttpRequest.newBuilder()
                .setClientIdentifier(clientIdentifier)
                .setEmployeeNames(Arrays.asList("Tim", "Jessica", "Mike"))
                .setRequestTime(10L)
                .build();
    }
}
