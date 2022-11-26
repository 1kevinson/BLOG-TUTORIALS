package com.example.demo.service;

import com.example.demo.config.AppConfigs;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.nio.file.Files;
import java.util.Date;
import java.util.Properties;

@Service
@RequiredArgsConstructor
public class MailService {

    private final AppConfigs appConfigs;

    public void sendSimpleMail() {
        Properties properties = getProperties();
        Session session = Session.getInstance(properties);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom("sender-test@example.com");
            message.setRecipients(Message.RecipientType.TO, "receiver-test@example.com");
            message.setSubject("Testing Javax Mail and MailHog");
            message.setSentDate(new Date());

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            File htmlFile = ResourceUtils.getFile("classpath:static/mail/content.html");
            String htmlFileContent = new String(Files.readAllBytes(htmlFile.toPath()));
            messageBodyPart.setContent(htmlFileContent, "text/html");

            MimeBodyPart imageBodyPart = new MimeBodyPart();
            File attachmentFile = ResourceUtils.getFile("classpath:static/attachments/email-logo.png");
            imageBodyPart.setHeader("Content-Id","<logoImage>");
            imageBodyPart.setDisposition(MimeBodyPart.INLINE);
            imageBodyPart.attachFile(attachmentFile);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(imageBodyPart);
            message.setContent(multipart);

            Transport.send(message);
        }catch (Exception exception) {
            System.out.println("Sending Email failed, error : " + exception.getMessage());
        }
    }

    private Properties getProperties() {
        Properties properties = new Properties();

        properties.put("mail.smtp.host", appConfigs.getHost());
        properties.put("mail.smtp.port", appConfigs.getPort());
        properties.put("mail.user", appConfigs.getPort());
        properties.put("mail.password", appConfigs.getPort());

        return properties;
    }
}
