# Notification Example Application

## Android 8.0 (SDK 26)

Android 8.0 Oreo 이상 버전은 `NotificationChannel`을 사용해야 한다.

### Android 8.0 Oreo 미만 버전

#### Example

```
Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
    .setContentTitle(CONTENT_TITLE)
    .setContentText(CONTEXT_TEXT)
    .setSmallIcon(R.drawable.ic_launcher_background)
    .build();

NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

notificationManager.notify(NOTIFICATION_ID, notification);
```

### Android 8.0 Oreo 이상 버전

#### Example

```
NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, CHANNEL_IMPORTANCE);

NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

notificationManager.createNotificationChannel(notificationChannel);

Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
    .setContentTitle(CONTENT_TITLE)
    .setContentText(CONTEXT_TEXT)
//  .setPriority()를 통해 Android 7.1 N_MR1 이하의 중요도(CHANNEL_IMPORTANCE) 호환 가능
    .build();

notificationManager.notify(NOTIFICATION_ID, notification);
```

로직을 통해 버전에 따라 채널 생성 여부를 결정할 수 있다.

```
private void createNotificationChannel() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, CHANNEL_IMPORTANCE);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.createNotificationChannel(notificationChannel);
    }
}
```

## Android 13.0 (SDK 33)

Android 13.0 Tiramisu 이상 버전부터 알림 관련 권한과 핸들링이 필요하다.

```
<uses-permission android:name="android.permission.POST_NOTIFICATIONS" />
```

## Reference

- [Create a Notification](https://developer.android.com/develop/ui/views/notifications/build-notification)
- [Create and manage notification channels](https://developer.android.com/develop/ui/views/notifications/channels)
- [Start an Activity from a Notification](https://developer.android.com/develop/ui/views/notifications/navigation)
- [Why do we use the TaskStackBuilder?](https://stackoverflow.com/questions/36912325/why-do-we-use-the-taskstackbuilder)
- Notification Id, Channel Id
    - [Notification, Channel, Group 차이](https://velog.io/@thevlakk/Android-Notification-ID%EC%99%80-Channel-ID-%EC%B0%A8%EC%9D%B4)
    - [Generate int unique id as android notification id](https://stackoverflow.com/questions/25713157/generate-int-unique-id-as-android-notification-id)
