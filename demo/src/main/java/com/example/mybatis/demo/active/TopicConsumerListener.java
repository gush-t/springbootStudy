package com.example.mybatis.demo.active;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumerListener {
    @JmsListener(destination = "${spring.activemq.topic-name}", containerFactory = "topicListener")
    public void topicListener(String message){
        System.out.println("topic receiver：" + message);
    }
}
