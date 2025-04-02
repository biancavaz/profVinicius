package com.exemple.exemplokafka.kafka.producer;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Bean
    //cria produtores kafka
    public ProducerFactory<String, String> producersFactory() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); //define o endereço kafka
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class); //serializa as chaves das mensagens
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class); //serializa os valores das mensagens
        return new DefaultKafkaProducerFactory<>(configProps); //gerencia produtores
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() { //facilita o envio da mensagem
        return new KafkaTemplate<>(producersFactory());
    }
}
