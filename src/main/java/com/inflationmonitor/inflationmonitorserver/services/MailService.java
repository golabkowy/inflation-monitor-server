package com.inflationmonitor.inflationmonitorserver.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;

@Service
@Configuration
public class MailService {

    private JavaMailSender javaMailSender;

    @Autowired
    public MailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(String to, String topic, String message) {
//        MimeMessagePreparator mmp = (msg) -> {
//            msg.setFrom(new InternetAddress("example@mail.com"));
//            msg.setRecipient(Message.RecipientType.TO, new InternetAddress("example@gmail.com"));
//            msg.setText("Test message from spring application");
//        };

        javaMailSender.send((msg) -> {
            msg.setFrom(new InternetAddress("example@mail.com"));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress("example@gmail.com"));
            msg.setText("Test message from spring application");
        });
    }
}
