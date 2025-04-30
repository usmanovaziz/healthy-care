package com.usmanov.pushyourself.config;

import com.usmanov.pushyourself.client.NotificationClient;
import com.usmanov.pushyourself.dto.NotificationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

@Configuration
public class GatewayConfig {

    @Autowired
    private NotificationClient notificationClient;

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth-service", r -> r.path("/auth/**")
                        .uri("lb://auth-service"))
                .route("user-profile-service", r -> r.path("/user-profile/**")
                        .uri("lb://user-profile-service"))
                .route("mood-tracker-service", r -> r.path("/mood-tracker/**")
                        .uri("lb://mood-tracker-service"))
                .route("challenge-service", r -> r.path("/challenge/**")
                        .uri("lb://challenge-service"))
                .build();
    }

    private GatewayFilter registerAndNotifyUser(){
        return (exchange, chain) ->{
            return chain.filter(exchange).then(
                    Mono.fromRunnable(() -> {
                        NotificationRequest request = new NotificationRequest();
                        request.setUserId("");
                        request.setTitle("Welcome!");
                        request.setBody("Thank you for registering!");

                        notificationClient.sendNotification(request);
                    })
            );
        };
    }
}
