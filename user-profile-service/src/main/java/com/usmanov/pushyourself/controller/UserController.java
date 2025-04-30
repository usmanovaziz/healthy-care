package com.usmanov.pushyourself.controller;

import com.usmanov.pushyourself.entity.UserProfile;
import com.usmanov.pushyourself.service.UserProfileService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/profile")
@AllArgsConstructor
public class UserController {

    private final UserProfileService profileService;

    @GetMapping(value = "/phone/{phone}")
    public ResponseEntity<Optional<UserProfile>> getUserProfile(@PathVariable String phone) {
        Optional<UserProfile> profile = profileService.getByPhoneNumber(phone);
        return profile.isPresent()
                ? ResponseEntity.ok(profile) :
                ResponseEntity.notFound().build();
    }
}
