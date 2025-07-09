package com.dswjp.muebleria_miley_movil;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;

import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String CHANNEL_ID = "default_channel";

    @RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        String title = "FCM";
        String body = "Mensaje recibido";

        if (remoteMessage.getNotification() != null) {
            title = remoteMessage.getNotification().getTitle();
            body = remoteMessage.getNotification().getBody();
        }

        if (remoteMessage.getData().size() > 0) {
            if (remoteMessage.getData().containsKey("title")) {
                title = remoteMessage.getData().get("title");
            }
            if (remoteMessage.getData().containsKey("body")) {
                body = remoteMessage.getData().get("body");
            }
        }

        showNotification(title, body);
    }

    @RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
    private void showNotification(String title, String body) {
        // Crear canal si es necesario (Android 8+)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    "Notificaciones FCM",
                    NotificationManager.IMPORTANCE_HIGH
            );
            NotificationManager manager = getSystemService(NotificationManager.class);
            if (manager != null) {
                manager.createNotificationChannel(channel);
            }
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.icon_notifications) // Usa un ícono válido en res/drawable
                .setContentTitle(title)
                .setContentText(body)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true);

        NotificationManagerCompat.from(this).notify(1001, builder.build());
    }

    @Override
    public void onNewToken(@NonNull String token) {
        Log.d("FCM", "Nuevo token: " + token);
        // Puedes enviar este token a tu servidor si lo necesitas
    }
}

