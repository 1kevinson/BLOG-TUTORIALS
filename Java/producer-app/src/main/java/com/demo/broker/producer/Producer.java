package com.demo.broker.producer;

import com.demo.broker.model.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private final JmsTemplate jmsTemplate;

    @Value("${spring.artemis.embedded.queues}")
    private String queueDestination;

    public Producer(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void send(Message message) {
        jmsTemplate.convertAndSend(queueDestination, message);
    }
}
