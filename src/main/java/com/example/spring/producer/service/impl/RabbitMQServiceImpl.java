package com.example.spring.producer.service.impl;

import com.example.spring.producer.broker.AmqpProducer;
import com.example.spring.producer.dto.Message;
import com.example.spring.producer.service.AmqpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQServiceImpl implements AmqpService {

    @Autowired
    private AmqpProducer<Message> amqpProducer;

    @Override
    public void sendToConsumer(Message message) {
        amqpProducer.producer(message);
    }
}
