package FoodOrderingApp.entities;

public class Restaurant {
    private String name;
    private boolean isAvail;
    private Menu menu;
    private Location location;
    

    public Restaurant(String name, Location loc) {
        this.name = name;
        this.location = loc;
        this.isAvail = true;
    }

    public boolean prepareFood(String orderId) {
        return isAvail;
    }

    public String getName() { return name; }
    public void setMenu(Menu menu) {
    this.menu = menu;
}

}
