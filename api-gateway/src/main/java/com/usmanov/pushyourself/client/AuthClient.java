package com.usmanov.pushyourself.client;

import com.usmanov.pushyourself.dto.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "auth-service", path = "/api/authentication")
public interface AuthClient {

    @PostMapping("/register")
    void registerUser(@RequestBody NotificationRequest request);
}
