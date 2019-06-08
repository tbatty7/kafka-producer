package com.battybuilds.kafkaproducer.config;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface MyMessageChannels {

    String OUTPUT = "outputChannel";

    @Output(MyMessageChannels.OUTPUT)
    MessageChannel outputChannel();
}
