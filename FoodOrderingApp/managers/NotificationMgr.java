package FoodOrderingApp.managers;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.List;
import FoodOrderingApp.interfaces.NotificationSender;

public class NotificationMgr {
    private static NotificationMgr notificationMgrInstance = null;
    private Map<String, List<NotificationSender>> notificationSendersMap = new ConcurrentHashMap<>();

    private NotificationMgr() {}

    public static NotificationMgr getNotificationMgr() {
        if (notificationMgrInstance == null) {
            synchronized (NotificationMgr.class) {
                if (notificationMgrInstance == null) {
                    notificationMgrInstance = new NotificationMgr();
                }
            }
        }
        return notificationMgrInstance;
    }

    public void notifyUser(String userId, String msg) {
        if(notificationSendersMap.containsKey(userId)) {
            for (NotificationSender sender : notificationSendersMap.get(userId)) {
                sender.sendNotification(userId, msg);
            }
        }
    }
}
