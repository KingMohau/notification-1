package com.example.whatsappmessagecollector;

import android.app.Notification;
import android.content.Context;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class NotificationListener extends NotificationListenerService {
    @Override
    public void onNotificationPosted(StatusBarNotification sbn) {
        Notification notification = sbn.getNotification();
        if (notification != null && sbn.getPackageName().equals("com.whatsapp")) {
            CharSequence tickerText = notification.tickerText;
            if (tickerText != null) {
                saveMessageToFile(getApplicationContext(), tickerText.toString());
            }
        }
    }

    private void saveMessageToFile(Context context, String message) {
        File path = context.getExternalFilesDir(null);
        File file = new File(path, "whatsapp_messages.txt");

        try (FileOutputStream fos = new FileOutputStream(file, true)) {
            fos.write((message + "\n").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
