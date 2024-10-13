package com.example.catalog.commons.configs.rabbitMQ;

import com.example.catalog.commons.models.EventModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RabbitMqProducer {

    private final RabbitTemplate rabbitTemplate;

    private final ObjectMapper objectMapper;

    public void sendMessage(EventModel eventModel) throws JsonProcessingException {
        CorrelationData correlationData =  new CorrelationData();
        correlationData.setId(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("pricing_exchange","pricing_queue_key", objectMapper.writeValueAsString(eventModel),correlationData);
    }


}
