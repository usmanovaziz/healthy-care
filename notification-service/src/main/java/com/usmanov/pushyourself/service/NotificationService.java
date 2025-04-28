package com.usmanov.pushyourself.service;


import org.springframework.context.event.EventListener;

public interface NotificationService {

    void sendSms(String destAddr, String message);

    void sendEmail(String destAddr, String message);

    //@EventListener
    //void onMerchantRegistrationEvent(UserRegistrationEvent event);
}
