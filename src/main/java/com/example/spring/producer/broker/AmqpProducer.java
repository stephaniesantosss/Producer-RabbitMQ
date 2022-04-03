package com.example.spring.producer.broker;

public interface AmqpProducer<T> {

    void producer(T t);
}
