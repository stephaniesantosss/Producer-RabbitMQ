package com.example.spring.producer.broker.impl;

import com.example.spring.producer.broker.AmqpProducer;
import com.example.spring.producer.dto.Message;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProducerRabbitMQ implements AmqpProducer<Message> {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.request.routing-key.producer}")
    private String queue;

    @Value("${spring.rabbitmq.request.exchange.producer}")
    private String exchange;

    @Override
    public void producer(Message message) {
        try {
            // enviando a msg para a fila
            rabbitTemplate.convertAndSend(exchange, queue, message);
        } catch (Exception exception) {
            // Quando ocorrer uma exceção ele irá mandar nossa msg para fila dlq
            throw new AmqpRejectAndDontRequeueException(exception);
        }
    }
}
