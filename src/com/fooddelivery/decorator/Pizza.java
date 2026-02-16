package com.fooddelivery.decorator;

/**
 * Concrete component - Base Pizza
 */
public class Pizza implements Food {
    private String name;
    private String size;
    private double basePrice;
    
    public Pizza(String name, String size, double basePrice) {
        this.name = name;
        this.size = size;
        this.basePrice = basePrice;
    }
    
    @Override
    public String getDescription() {
        return size + " " + name;
    }
    
    @Override
    public double getPrice() {
        return basePrice;
    }
    
    @Override
    public String getItemName() {
        return name;
    }
}

