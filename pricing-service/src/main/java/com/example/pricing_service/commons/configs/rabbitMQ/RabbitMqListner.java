package com.example.pricing_service.commons.configs.rabbitMQ;


import com.example.pricing_service.services.PricingService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitMqListner {

    private final PricingService pricingService;

    @RabbitListener(queues = "pricing_queue")
    public void receiveMessage(String jsonString){

        pricingService.readFromQueueAndSave(jsonString);

    }

}
