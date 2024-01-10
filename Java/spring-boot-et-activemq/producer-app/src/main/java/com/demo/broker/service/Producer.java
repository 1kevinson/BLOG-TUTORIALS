package com.demo.broker.service;

import com.demo.broker.model.Message;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Producer {

    Logger logger = LoggerFactory.getLogger(Producer.class);

    private final ObjectMapper mapper;
    private final JmsTemplate jmsTemplate;

    @Value("${spring.artemis.embedded.queues}")
    private String artemisQueue;

    public void send(Message message) {
        try {
            String jmsMessage = mapper.writeValueAsString(message);
            logger.info("Sending Message :: {}", jmsMessage);
            jmsTemplate.convertAndSend(artemisQueue, jmsMessage);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
