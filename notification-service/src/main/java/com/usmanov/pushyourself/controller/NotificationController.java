package com.usmanov.pushyourself.controller;

import com.usmanov.pushyourself.entity.NotificationEvent;
import com.usmanov.pushyourself.service.notification.NotificationPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/notification")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationPublisher notificationPublisher;

    @PostMapping("/notify")
    public void notify(@RequestBody NotificationEvent event) {
        notificationPublisher.sendNotification(
                event.getUserId(),
                event.getChannel(),
                event.getTitle(),
                event.getBody()
        );
    }
}
