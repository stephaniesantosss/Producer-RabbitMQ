package com.example.spring.producer.api;

import com.example.spring.producer.dto.Message;
import com.example.spring.producer.service.AmqpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.ACCEPTED;

@RestController
public class AmqpApi {

    @Autowired
    private AmqpService amqpService;

    @ResponseStatus(ACCEPTED)
    @PostMapping("/send")
    public void sendToConsumer(@RequestBody Message message) {
        amqpService.sendToConsumer(message);
    }
}
