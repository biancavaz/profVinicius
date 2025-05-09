package com.exemple.exemplokafka.kafka.controller;

import com.exemple.exemplokafka.kafka.producer.MessageProducer;
//import com.teste.teste.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    @Autowired
    private MessageProducer messageProducer;

    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String message) {
        messageProducer.sendMessage("lasteste", message);
        return "Message sent: " + message;
    }
}
