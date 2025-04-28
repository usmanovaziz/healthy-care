package com.usmanov.pushyourself.service.stubs;

import com.usmanov.pushyourself.entity.HealthGoalStatistics;
import com.usmanov.pushyourself.entity.UserProfile;
import com.usmanov.pushyourself.entity.UserStatistics;
import com.usmanov.pushyourself.enums.*;
import com.usmanov.pushyourself.errors.UserNotFoundException;
import com.usmanov.pushyourself.repository.UserProfileRepository;
import com.usmanov.pushyourself.service.UserProfileService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserProfileServiceImpl implements UserProfileService {

    private final UserProfileRepository userProfileRepository;

    @Override
    public Optional<UserProfile> getProfileById(UUID userId) {
        return Optional.ofNullable(userProfileRepository.findById(userId)
                                  .orElseThrow(UserNotFoundException::new));
    }

    @Override
    public boolean isProfileComplete(UUID userId) {
        UserProfile userProfile = userProfileRepository.findById(userId).orElse(null);

        if (userProfile == null) {
            return false;
        }

        boolean isComplete = true;
        isComplete &= userProfile.getFirstName() != null && !userProfile.getFirstName().isEmpty();
        isComplete &= userProfile.getLastName() != null && !userProfile.getLastName().isEmpty();
        isComplete &= userProfile.getAge() != null && userProfile.getAge() > 0;
        isComplete &= userProfile.getGender() != null;
        isComplete &= userProfile.getLanguagePreference() != null;
        isComplete &= userProfile.getDeviceType() != null;

        isComplete &= userProfile.isFingerprintEnabled() || userProfile.isFaceRecognitionEnabled();

        isComplete &= userProfile.hasCompletedProfileSetup();

        isComplete &= userProfile.isAppInstalled();
        isComplete &= userProfile.getNotification() != null && !userProfile.getNotification().equals(NotificationPreference.NONE);

        userProfileRepository.save(userProfile);
        return isComplete;
    }

    @Override
    public void updateProfile(UUID userId, UserProfile updatedProfile) {

    }

    @Override
    public void setHealthGoal(UUID userId, HealthGoal goal) {
        userProfileRepository.findById(userId)
                .map(profile -> {
                    profile.setHealthGoal(goal);
                    return userProfileRepository.save(profile);
        })
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public Integer getSessionCount(UUID userId) {
        return userProfileRepository.findById(userId)
                .map(UserProfile::getSessionCount)
                .orElseThrow(() -> new UserNotFoundException("UserProfile not found with id: " + userId));
    }

    @Override
    @Transactional
    public void setNotificationPreferences(UUID userId, NotificationPreference preference) {
        userProfileRepository.findById(userId)
                .map(profile -> {
                    profile.setNotification(preference);
                    return userProfileRepository.save(profile);
                })
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public boolean areNotificationsEnabled(UUID userId) {
        Optional<UserProfile> optionalProfile = userProfileRepository.findById(userId);

        return optionalProfile.isPresent() && optionalProfile.get().getNotification() != null
                && !optionalProfile.get().getNotification().equals(NotificationPreference.NONE);
    }

    @Override
    public Instant getLastNotificationTime(UUID userId) {
        return userProfileRepository.findById(userId).get().getLastNotificationTime();
    }

    @Override
    public void setDeviceSettings(UUID userId, boolean isFingerprintEnabled, boolean isFaceRecognitionEnabled) {
        //TODO think logic and implement it
    }

    @Override
    public DeviceType getDeviceType(UUID userId) {
        return null;
    }

    @Override
    public boolean isAvailableForConsultation(UUID userId) {
        UserProfile profile = userProfileRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));

        boolean canConsult = canUnlockConsultation(profile);
        profile.setAvailableForConsultation(canConsult);
        userProfileRepository.save(profile);

        return canConsult;
    }

    @Override
    public void setNotificationReminderTime(UUID userId, Instant reminderTime) {
        Optional<UserProfile> optProfile = userProfileRepository.findById(userId);
    }

    @Override
    public void scheduleConsultation(UUID userId, TherapyType therapyType, Instant appointmentTime) {
        //TODO think logic and implement it
    }

    @Override
    public void updateVisitHistory(UUID userId, String newVisitHistory) {
        //TODO think logic and implement it
    }

    @Override
    public TherapyType getPreferredTherapyType(UUID userId) {
        return userProfileRepository.findById(userId).get().getPreferredTherapyType();
    }

    @Override
    public boolean isAppInstalled(UUID userId) {
        return userProfileRepository.findById(userId).get().isAppInstalled();
    }

    @Override
    public void updateLanguagePreference(UUID userId, Language newLanguage) {
        UserProfile profile = userProfileRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Error while updating language, user not found with id: " + userId));

        profile.setLanguagePreference(newLanguage);
        userProfileRepository.save(profile);
    }

    @Override
    public Instant getLastAppOpened(UUID userId) {
        //TODO think logic and implement it
        return null;
    }

    @Override
    public UserStatistics getUserStatistics(UUID userId) {
        //TODO think logic and implement it
        return null;
    }

    @Override
    public HealthGoalStatistics getHealthGoalStatistics(UUID userId) {
        //TODO think logic and implement it
        return null;
    }

    private boolean canUnlockConsultation(UserProfile profile) {
        return profile.hasCompletedProfileSetup()
                && profile.getPreferredTherapyType() != null
                && profile.getHealthGoal() != null
                && profile.isAppInstalled()
                && profile.getPrivacySettings() != PrivacySettings.PRIVATE
                && profile.getLastAppOpenedAt() != null;
    }
}
