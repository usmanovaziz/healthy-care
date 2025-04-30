package com.usmanov.pushyourself.service.notification;

import com.usmanov.pushyourself.config.RabbitMQConfig;
import com.usmanov.pushyourself.entity.NotificationEvent;
import com.usmanov.pushyourself.enums.Channel;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class NotificationPublisher {

    private final RabbitTemplate rabbitTemplate;

    public void sendNotification(UUID userId, Channel channel, String title, String body) {
        NotificationEvent event = new NotificationEvent();
        event.setUserId(userId);
        event.setChannel(channel);
        event.setTitle(title);
        event.setBody(body);
        event.setSent(true);

        rabbitTemplate.convertAndSend(RabbitMQConfig.NOTIFICATION_EXCHANGE, RabbitMQConfig.NOTIFICATION_ROUTING_KEY, event);
    }
}
