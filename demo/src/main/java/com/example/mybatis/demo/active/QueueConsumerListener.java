package com.example.mybatis.demo.active;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumerListener {

    @JmsListener(destination = "${spring.activemq.queue-name}" , containerFactory = "queueListener")
    public void readActiveQueue(String message){
        System.out.println("queue receive: " + message);
    }
}
