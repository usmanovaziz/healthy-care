package com.usmanov.pushyourself.service.sender;


import com.usmanov.pushyourself.entity.NotificationEvent;
import com.usmanov.pushyourself.sender.NotificationSender;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class EmailNotificationSender implements NotificationSender {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void send(NotificationEvent notification) {
        log.info("Sending Email notification to {}: {}", notification.getChannel(), notification.getBody());

        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(notification.getChannel().EMAIL.toString());
            helper.setSubject(notification.getTitle());
            helper.setText(notification.getBody(), true);

            mailSender.send(message);

            log.info("Email sent successfully to {}", notification.getChannel());

        } catch (MessagingException e) {
            log.error("Failed to send email notification", e);
        }
    }
}
