package com.example.mybatis.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

@RestController
public class ProductController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;
    @Autowired
    private Topic topic;

    public void sendMessage(Destination destination, String message){
        jmsMessagingTemplate.convertAndSend(destination,message);
    }

    @PostMapping("queue/test")
    public String queueSend(@RequestBody String string){
        this.sendMessage(this.queue,string);
        return "success";
    }

    @PostMapping("topic/test")
    public String topicSend(@RequestBody String string){
        this.sendMessage(this.topic,string);
        return  "success";
    }
}
