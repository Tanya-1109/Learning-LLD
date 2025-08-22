package FoodOrderingApp.entities;

import FoodOrderingApp.interfaces.NotificationSender;

public class PushNotificationSender implements NotificationSender {
    @Override
    public void sendNotification(String userId, String msg) {
        System.out.println("Push notification to " + userId + ": " + msg);
    }
}
