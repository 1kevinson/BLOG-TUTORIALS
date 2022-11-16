package com.example.demo.files;

import com.icegreen.greenmail.configuration.GreenMailConfiguration;
import com.icegreen.greenmail.junit5.GreenMailExtension;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetupTest;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class EmailControllerTest {

    @RegisterExtension
    static GreenMailExtension greenMail = new GreenMailExtension(ServerSetupTest.SMTP)
            .withConfiguration(GreenMailConfiguration.aConfig().withUser("user", "admin"))
            .withPerMethodLifecycle(false);

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    void should_send_email_to_user() throws MessagingException, JSONException {
        // Arrange
        JSONObject emailJsonObject = new JSONObject();
        emailJsonObject.put("email", "tester@spring.com");
        emailJsonObject.put("content", "Hello this is a simple email message");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> emailRequest = new HttpEntity<>(emailJsonObject.toString(), headers);

        // Act
        ResponseEntity<Void> response = testRestTemplate.postForEntity("/notify/user", emailRequest, Void.class);

        // Assert
        assertEquals(200, response.getStatusCodeValue());

        MimeMessage receivedMessage = greenMail.getReceivedMessages()[0];
        assertEquals(1, receivedMessage.getAllRecipients().length);
        assertEquals("tester@spring.com", receivedMessage.getAllRecipients()[0].toString());
        assertEquals("test.sender@hotmail.com", receivedMessage.getFrom()[0].toString());
        assertEquals("Message from Java Mail Sender", receivedMessage.getSubject());
        assertEquals("Hello this is a simple email message", GreenMailUtil.getBody(receivedMessage));
    }
}

/* TODO: 13/11/2022
 *   1- List the meaning of all annotations in article
 *   2 - inspire by rieckpill article
 *   3- Article title ->  Sending Email with Spring Mail and Integration Testing with Green Mail */