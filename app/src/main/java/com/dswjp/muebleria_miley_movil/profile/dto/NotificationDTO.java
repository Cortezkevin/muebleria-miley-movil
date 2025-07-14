package com.dswjp.muebleria_miley_movil.profile.dto;

import com.dswjp.muebleria_miley_movil.profile.model.Notification;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class NotificationDTO {
    String id;
    String title;
    String body;
    Timestamp date;

    public static NotificationDTO toDTO(Notification notification){
        return new NotificationDTO(
                notification.getId(),
                notification.getTitle(),
                notification.getBody(),
                notification.getDate()
        );
    }
}
