package com.usmanov.pushyourself.service.sender;

import com.usmanov.pushyourself.entity.NotificationEvent;
import com.usmanov.pushyourself.sender.NotificationSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SmsNotificationSender implements NotificationSender {

    public void send(NotificationEvent notification) {
        // Логика отправки Push
        log.info("Sending SMS notification to {}: {}", notification.getUserId(), notification.getBody());
        // Например, через Firebase Cloud Messaging (FCM)
    }
}
