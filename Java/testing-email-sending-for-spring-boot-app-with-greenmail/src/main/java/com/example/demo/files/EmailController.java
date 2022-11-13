package com.example.demo.files;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notify")
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/user")
    public void createEmailNotification(@Valid @RequestBody EmailRequest request) {
        emailService.notifyUser(request.getEmail(), request.getContent());
    }
}


