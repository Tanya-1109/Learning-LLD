package FoodOrderingApp.entities;

import FoodOrderingApp.interfaces.IPartner;

public class DeliveryPartner implements IPartner {
    private String name;

    public DeliveryPartner(String name) {
        this.name = name;
    }

    public void performDelivery(String orderId, DeliveryMetaData metaData) {
        // delivery logic
    }

    @Override
    public void performMyX() {
        // partner specific task
    }
    @Override
    public String toString() {
    return "DeliveryPartner{name='" + name + "'}";
}

}
