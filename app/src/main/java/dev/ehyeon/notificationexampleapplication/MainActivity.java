package dev.ehyeon.notificationexampleapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button notificationButton = findViewById(R.id.notification_button);

        String channelId = "channelId";

        int notificationId = 0;

        // 1. NotificationManager에 NotificationChannel 등록
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        NotificationChannel notificationChannel =
                new NotificationChannel(channelId, "testName", NotificationManager.IMPORTANCE_DEFAULT);

        notificationManager.createNotificationChannel(notificationChannel);

        // 2. Notification Builder를 통해 Notification 생성
        Notification notification = new NotificationCompat.Builder(this, channelId)
                .setContentTitle("Title")
                .setContentText("Text")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .build();

        notificationButton.setOnClickListener(view -> notificationManager.notify(notificationId, notification));
    }
}
