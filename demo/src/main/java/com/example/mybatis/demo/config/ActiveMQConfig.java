package com.example.mybatis.demo.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;

import javax.jms.*;

@Configuration
public class ActiveMQConfig {

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;
    @Value("${spring.activemq.user}")
    private String activeName;

    @Value("${spring.activemq.password}")
    private String activePassword;
    @Value("${spring.activemq.queue-name}")
    private String activeQueue;
    @Value("${spring.activemq.topic-name}")
    private String activeTopic;

    @Bean(name = "queue")
    public Queue queue() {
        return new ActiveMQQueue(activeQueue);
    }

    @Bean(name = "topic")
    public Topic topic() {
        return new ActiveMQTopic(activeTopic);
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory(activeName, activePassword, brokerUrl);
    }

    @Bean
    public JmsMessagingTemplate jmsMessagingTemplate() {
        return new JmsMessagingTemplate(connectionFactory());
    }

    /**
     * @param connectionFactory
     * @return
     */
    @Bean(name = "queueListener")
    public JmsListenerContainerFactory<?> queueJmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(false);
        return factory;
    }

    /**
     * @param connectionFactory
     * @return
     */
    @Bean(name = "topicListener")
    public JmsListenerContainerFactory<?> topicJmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setPubSubDomain(true);
        return factory;
    }
}
