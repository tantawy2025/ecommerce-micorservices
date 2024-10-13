package com.example.catalog.commons.configs.rabbitMQ;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Bean
    public Queue queue(){
        return new Queue("pricing_queue");
    }

    @Bean
    public Exchange exchange(){
        return new TopicExchange("pricing_exchange");
    }

    @Bean
    public Binding binding(Queue queue, Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("pricing_queue_key").noargs();

    }

}
