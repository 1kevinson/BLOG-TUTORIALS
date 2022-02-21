package com.demo.broker.consumer;

import com.demo.broker.model.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);
    private final ObjectMapper mapper;

    public MessageConsumer(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @JmsListener(destination = "${spring.artemis.embedded.queues}")
    public void messageListener(String message){
        LOGGER.info("Message received, {}",message);
    }

}
