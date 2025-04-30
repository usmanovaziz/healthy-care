package com.usmanov.pushyourself.listener;

import com.usmanov.pushyourself.config.RabbitMQConfig;
import com.usmanov.pushyourself.entity.NotificationEvent;
import com.usmanov.pushyourself.repository.NotificationRepository;
import com.usmanov.pushyourself.service.NotificationSenderFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationEventListener {

    private final NotificationSenderFactory factory;
    private final NotificationRepository repo;

    @RabbitListener(queues = RabbitMQConfig.NOTIFICATION_QUEUE)
    public void handleEvent(NotificationEvent event) {

        var channelType = event.getChannel();
        var sender = factory.getSender(channelType);
        sender.send(event);

        event.setSent(true);
        repo.save(event);
    }
}
