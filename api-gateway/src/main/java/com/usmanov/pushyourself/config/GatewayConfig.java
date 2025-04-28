package com.usmanov.pushyourself.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

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
}
