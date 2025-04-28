package com.usmanov.pushyourself.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RefreshTokens {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(columnDefinition = "TEXT")
    private String token;

    @CreationTimestamp
    private Instant createdAt;

    @Column(name = "expires_at")
    private Date expiresAt;
}
