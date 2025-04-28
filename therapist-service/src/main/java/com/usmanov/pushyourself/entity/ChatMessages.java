package com.usmanov.pushyourself.entity;

import com.usmanov.pushyourself.enums.SenderType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChatMessages {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID sessionId;

    @Enumerated(EnumType.STRING)
    private SenderType senderType;

    private UUID senderId;

    private String message;

    private LocalDateTime sentAt;
}
