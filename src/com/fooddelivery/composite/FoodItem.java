package com.fooddelivery.composite;

/**
 * Leaf class - represents an individual menu item
 */
public class FoodItem implements MenuComponent {
    private String name;
    private String description;
    private double price;
    private boolean vegetarian;
    private String spiceLevel; // MILD, MEDIUM, HOT
    
    public FoodItem(String name, String description, double price, boolean vegetarian) {
        this(name, description, price, vegetarian, "MILD");
    }
    
    public FoodItem(String name, String description, double price, boolean vegetarian, String spiceLevel) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.vegetarian = vegetarian;
        this.spiceLevel = spiceLevel;
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String getDescription() {
        return description;
    }
    
    @Override
    public double getPrice() {
        return price;
    }
    
    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }
    
    public String getSpiceLevel() {
        return spiceLevel;
    }
    
    @Override
    public void display(int indent) {
        String indentation = repeatString("  ", indent);
        String vegIcon = vegetarian ? "🟢" : "🔴";
        String spiceIcon = getSpiceIcon();
        
        System.out.println(indentation + vegIcon + " " + name + " " + spiceIcon + " - ₹" + String.format("%.2f", price));
        System.out.println(indentation + "    " + description);
    }
    
    private String repeatString(String str, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
    
    private String getSpiceIcon() {
        switch (spiceLevel) {
            case "HOT": return "🌶🌶🌶";
            case "MEDIUM": return "🌶🌶";
            case "MILD": return "🌶";
            default: return "";
        }
    }
    
    @Override
    public String toString() {
        return name + " (₹" + price + ")";
    }
}


