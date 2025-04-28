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
public class HealthGoalStatistics {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String goalName;
    private Double targetValue;
    private Double currentValue;
    private Integer progressPercentage;
    private Instant goalStartDate;
    private Instant goalTargetDate;
    private Integer daysLeft;
    private Integer updatesCount;
    private boolean isAchieved;
}
