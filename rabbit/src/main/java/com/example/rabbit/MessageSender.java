package com.example.rabbit;

import com.example.rabbit.model.UserProfile;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;

public class MessageSender {
    @Autowired
    private TopicExchange topic;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void addUser(UserProfile customer) {
        String key = "create.user";
        String json = UtilService.convertJson(customer);
        System.out.println(json);
        rabbitTemplate.convertAndSend(topic.getName(), key, json);
    }

    public void testMessage(String message) {
        String key = "send.user";
        rabbitTemplate.convertAndSend(topic.getName(), key, message);
    }
}