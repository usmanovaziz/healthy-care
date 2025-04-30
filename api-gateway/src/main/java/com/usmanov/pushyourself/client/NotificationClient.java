package com.usmanov.pushyourself.client;

import com.usmanov.pushyourself.dto.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service", path = "/api/notification")
public interface NotificationClient {

    @PostMapping("/notify")
    void sendNotification(@RequestBody NotificationRequest request);
}
