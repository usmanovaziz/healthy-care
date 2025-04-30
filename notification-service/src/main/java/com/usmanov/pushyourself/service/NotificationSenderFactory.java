package com.usmanov.pushyourself.service;

import com.usmanov.pushyourself.enums.Channel;
import com.usmanov.pushyourself.sender.NotificationSender;
import com.usmanov.pushyourself.service.sender.EmailNotificationSender;
import com.usmanov.pushyourself.service.sender.PushNotificationSender;
import com.usmanov.pushyourself.service.sender.SmsNotificationSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationSenderFactory {

    private final EmailNotificationSender emailNotificationSender;
    private final PushNotificationSender pushNotificationSender;
    private final SmsNotificationSender smsNotificationSender;


    public NotificationSender getSender(Channel channel) {
        switch (channel) {
            case EMAIL:
                return emailNotificationSender;
            case PUSH:
                return pushNotificationSender;
            case SMS:
                return smsNotificationSender;
            default:
                throw new IllegalArgumentException("Unsupported notification channel: " + channel);
        }
    }
}
