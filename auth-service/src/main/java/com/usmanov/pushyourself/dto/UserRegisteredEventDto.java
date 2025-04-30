package com.usmanov.pushyourself.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisteredEventDto implements Serializable {

    private UUID userId;
    private String channel;
    private String notificationType;
    private String title;
    private String body;
    private boolean sent;

}
