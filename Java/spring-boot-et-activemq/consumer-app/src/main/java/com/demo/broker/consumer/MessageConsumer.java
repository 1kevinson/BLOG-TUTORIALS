package com.demo.broker.consumer;

import org.slf4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class MessageConsumer {

    Logger LOGGER = getLogger(MessageConsumer.class);

    @JmsListener(destination = "${spring.artemis.embedded.queues}")
    public void messageListener(String message) {
        LOGGER.info("Message received, {}", message);
    }

}
