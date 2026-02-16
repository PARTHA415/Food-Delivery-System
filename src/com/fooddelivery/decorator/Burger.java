package com.fooddelivery.decorator;

/**
 * Concrete component - Base Burger
 */
public class Burger implements Food {
    private String name;
    private String type;
    private double basePrice;
    
    public Burger(String name, String type, double basePrice) {
        this.name = name;
        this.type = type;
        this.basePrice = basePrice;
    }
    
    @Override
    public String getDescription() {
        return type + " " + name;
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

