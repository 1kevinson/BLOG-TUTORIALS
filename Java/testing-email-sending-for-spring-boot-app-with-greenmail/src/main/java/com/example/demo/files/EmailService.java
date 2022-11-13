package com.example.demo.files;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void notifyUser(String email, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("test.sender@hotmail.com");
        message.setSubject("Message from Java Mail Sender");
        message.setText(content);
        message.setTo(email);

        mailSender.send(message);
    }
}
