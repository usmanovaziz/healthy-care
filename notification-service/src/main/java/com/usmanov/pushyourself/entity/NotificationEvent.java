package com.usmanov.pushyourself.entity;

import com.usmanov.pushyourself.enums.Channel;
import com.usmanov.pushyourself.enums.NotificationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationEvent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID userId;

    @Enumerated(EnumType.STRING)
    private Channel channel;

    @Enumerated(EnumType.STRING)
    private NotificationType notificationType;

    private String title;

    private String body;

    private String recipient;

    private LocalDate scheduledDate;

    private Boolean sent;

    @CreationTimestamp
    private LocalDate createdAt;
}
