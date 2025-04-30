package com.usmanov.pushyourself.sender;

import com.usmanov.pushyourself.entity.NotificationEvent;

public interface NotificationSender {
    void send(NotificationEvent notification);
}
