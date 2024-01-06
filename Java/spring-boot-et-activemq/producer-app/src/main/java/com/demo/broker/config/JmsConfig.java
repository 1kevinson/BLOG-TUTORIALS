package com.demo.broker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

@EnableJms
@Configuration
public class JmsConfig {

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory) {
        var jmsListenerFactory = new DefaultJmsListenerContainerFactory();
        jmsListenerFactory.setConnectionFactory(connectionFactory);
        jmsListenerFactory.setConcurrency("2-4");
        return jmsListenerFactory;
    }

}
