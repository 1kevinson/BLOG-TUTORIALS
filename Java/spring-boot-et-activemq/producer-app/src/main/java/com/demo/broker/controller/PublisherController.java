package com.demo.broker.controller;

import com.demo.broker.model.Message;
import com.demo.broker.service.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
public class PublisherController {

    private final Producer producer;

    @PostMapping
    public ResponseEntity<String> publish(@RequestBody Message message) {
        try {
            producer.send(message);
            return new ResponseEntity<>("Message Sent", HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
