package com.example.catalog.commons.handlers;

import com.example.catalog.commons.configs.rabbitMQ.RabbitMqProducer;
import com.example.catalog.commons.models.EventModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class EventHandler {

    private final RabbitMqProducer rabbitMqProducer;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleOrders(EventModel eventModel) throws JsonProcessingException {
        rabbitMqProducer.sendMessage(eventModel);
    }

}
