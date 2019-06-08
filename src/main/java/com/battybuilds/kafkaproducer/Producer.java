package com.battybuilds.kafkaproducer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Producer {

    @GetMapping("/")
    public String sendMessage() {


        return "message NOT sent!";
    }
}
