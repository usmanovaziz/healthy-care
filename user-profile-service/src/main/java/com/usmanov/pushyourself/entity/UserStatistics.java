package com.usmanov.pushyourself.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID userId;
    private Integer sessionCount;
    private Double averageSessionDuration;
    private Integer loginFrequency;
    private Integer stepCount;
    private Integer averageSleepDuration;
    private Integer notificationCount;
    private Integer completedGoals;
    private Instant lastLoginTime;
    private Instant lastNotificationReceivedAt;
}
