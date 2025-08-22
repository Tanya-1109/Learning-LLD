package FoodOrderingApp.entities;

import java.util.List;

public class Dish {
    private String name;
    private String description;
    private String cuisine;
    private double price;
    private List<String> dishImages;

    public Dish(String name, String cuisine, double price) {
        this.name = name;
        this.cuisine = cuisine;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
}
