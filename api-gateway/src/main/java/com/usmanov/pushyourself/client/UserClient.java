package com.usmanov.pushyourself.client;

import com.usmanov.pushyourself.dto.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(name = "auth-service", path = "/api/userprofile")
public interface UserClient {

    @PostMapping("/register")
    void getUser(@RequestBody UUID userId);
}
