package com.usmanov.pushyourself.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID userId;

    private String channel;

    private String title;

    private String body;

    private LocalDate scheduledDate;

    private Boolean sent;

    @CreationTimestamp
    private LocalDate createdAt;
}
