package com.battybuilds.kafkaproducer;

import com.battybuilds.kafkaproducer.avro.model.AvroHttpRequest;
import com.battybuilds.kafkaproducer.avro.model.ClientIdentifier;
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

    public Producer(MyMessageChannels myMessageChannels) {
        this.myMessageChannels = myMessageChannels;
    }

    @GetMapping("/")
    public String sendMessage() {
        Object request = createAvroHttpRequest();

        myMessageChannels.outputChannel().send(MessageBuilder.withPayload("hello").build());

        return "message NOT sent!";
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
