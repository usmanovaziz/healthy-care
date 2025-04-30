package com.usmanov.pushyourself.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class OtpNotificationRequest {

    private UUID userId;
    private String phoneNumber;
    private String otpCode;
}
