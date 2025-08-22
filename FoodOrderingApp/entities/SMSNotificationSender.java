package FoodOrderingApp.entities;

import FoodOrderingApp.interfaces.NotificationSender;

public class SMSNotificationSender implements NotificationSender {
    @Override
    public void sendNotification(String userId, String msg) {
        System.out.println("SMS to " + userId + ": " + msg);
    }
}
