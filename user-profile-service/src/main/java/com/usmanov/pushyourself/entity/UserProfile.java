package com.usmanov.pushyourself.entity;

import com.usmanov.pushyourself.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private UUID userId;

    @Column(columnDefinition = "first_name")
    private String firstName;

    @Column(columnDefinition = "last_name")
    private String lastName;

    private Integer age;

    @Column(unique = true)
    private String phoneNumber;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Language languagePreference;

    @Enumerated(EnumType.STRING)
    private NotificationPreference notification;

    @Enumerated(EnumType.STRING)
    private PrivacySettings privacySettings;

    private String timezone;

    @Enumerated(EnumType.STRING)
    private ActivityLevel activityLevel;

    @Enumerated(EnumType.STRING)
    private HealthGoal healthGoal;

    @Enumerated(EnumType.STRING)
    private DeviceType deviceType;

    private boolean notificationEnabled;

    private String visitHistory;

    private String sleepSchedule;

    private Integer averageSleepDuration;

    private boolean isAppInstalled;

    private Instant lastAppOpenedAt;

    private boolean hasCompletedProfileSetup;

    private boolean isFingerprintEnabled;

    @Enumerated(EnumType.STRING)
    private TherapyType preferredTherapyType;

    private boolean isFaceRecognitionEnabled;

    private Integer sessionCount;

    private String medicalHistory;

    private Instant notificationReminderTime;

    private boolean isAvailableForConsultation;

    private Instant lastNotificationTime;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;


    public boolean hasCompletedProfileSetup(){
        return this.hasCompletedProfileSetup;
    }

    @PrePersist
    public void prePersist(){
        notificationEnabled = false;
        notification = NotificationPreference.PUSH;
    }
}
