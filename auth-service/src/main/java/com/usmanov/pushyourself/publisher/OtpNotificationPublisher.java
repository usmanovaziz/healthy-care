package com.usmanov.pushyourself.publisher;

import com.usmanov.pushyourself.config.RabbitMQConfig;
import com.usmanov.pushyourself.dto.UserRegisteredEventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OtpNotificationPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void sendOtp(UUID userId, String phoneNumber, String otpCode) {
        UserRegisteredEventDto event = new UserRegisteredEventDto();
        event.setUserId(userId);
        event.setChannel("SMS");
        event.setNotificationType("OTP");
        event.setTitle("Код подтверждения");
        event.setBody("Ваш код подтверждения: " + otpCode);
        event.setSent(false);

        rabbitTemplate.convertAndSend(
                RabbitMQConfig.NOTIFICATION_EXCHANGE,
                RabbitMQConfig.NOTIFICATION_ROUTING_KEY,
                event
        );
    }
}
