package com.example.rabbit;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageSender {
    @Autowired
    private TopicExchange topic;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void addUser(UserProfile customer) {
        String key = "create.user";
        rabbitTemplate.convertAndSend(topic.getName(), key, customer);
    }

    public void testMessage(String message) {
        String key = "send.user";
        rabbitTemplate.convertAndSend(topic.getName(), key, message);
    }

}