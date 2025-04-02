package com.exemple.exemplokafka.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    //faz o envio da mensagem
    public void sendMessage(String topico, String mensagem) {
        kafkaTemplate.send(topico, mensagem);
    }
}
