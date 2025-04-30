package com.usmanov.pushyourself.service;

import com.usmanov.pushyourself.entity.HealthGoalStatistics;
import com.usmanov.pushyourself.entity.UserProfile;
import com.usmanov.pushyourself.entity.UserStatistics;
import com.usmanov.pushyourself.enums.*;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

public interface UserProfileService {

    Optional<UserProfile> getProfileById(UUID userId);

    boolean isProfileComplete(UUID userId);

    void updateProfile(UUID userId, UserProfile updatedProfile);

    void setHealthGoal(UUID userId, HealthGoal goal);

    Optional<UserProfile> getByPhoneNumber(String phoneNumber);

    Integer getSessionCount(UUID userId);

    void setNotificationPreferences(UUID userId, NotificationPreference preference);

    boolean areNotificationsEnabled(UUID userId);

    Instant getLastNotificationTime(UUID userId);

    void setDeviceSettings(UUID userId, boolean isFingerprintEnabled, boolean isFaceRecognitionEnabled);

    DeviceType getDeviceType(UUID userId);

    boolean isAvailableForConsultation(UUID userId);

    void setNotificationReminderTime(UUID userId, Instant reminderTime);

    void scheduleConsultation(UUID userId, TherapyType therapyType, Instant appointmentTime);

    void updateVisitHistory(UUID userId, String newVisitHistory);

    TherapyType getPreferredTherapyType(UUID userId);

    boolean isAppInstalled(UUID userId);

    void updateLanguagePreference(UUID userId, Language newLanguage);

    Instant getLastAppOpened(UUID userId);

    UserStatistics getUserStatistics(UUID userId);

    HealthGoalStatistics getHealthGoalStatistics(UUID userId);
}
