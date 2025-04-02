package com.exemple.exemplokafka.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
    //recebe mensagem e envia no console
    //ouve mensagens do kafka
    @KafkaListener(
            topics = "lasteste", //nome do tópico que vai receber as imagens
            groupId = "1") //identifica o grupo de consumidores
    public void ouvir(String mensagem) {
        System.out.println("Mensagem recebida: " + mensagem);
    }
}
