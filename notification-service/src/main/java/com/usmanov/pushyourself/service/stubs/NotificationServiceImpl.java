package com.usmanov.pushyourself.service.stubs;

import com.usmanov.pushyourself.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {


    @Override
    public void sendSms(String destAddr, String message) {
//        String[] phones = destAddr.trim().replaceAll("\\s", "").split(",");
//        for (String msisdn : phones) {
//            if (msisdn != null && !msisdn.isEmpty()) {
//                log.info("SMS send :: phone: {} text: {} ", msisdn, txt);
//                try {
//                    rabbitTemplate.convertAndSend("system-notification-service", "notify", "SMS send :: phone: " + msisdn + " text: " + txt);
//                } catch (Exception e) {
//                    log.error("Rabbit exchange system-notification-service can't respond to request for messenger notification");
//                }
//            }
//        }
    }

    @Override
    public void sendEmail(String destAddr, String message) {

    }
}
