package com.example.demo.controller;

import com.example.demo.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/mail")
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @GetMapping("/send-simple-mail")
    void sendMail() {
        mailService.sendSimpleMail();
    }
}
