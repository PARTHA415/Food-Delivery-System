package com.fooddelivery.decorator;

/**
 * Concrete Decorator - Sauce options
 */
public class SauceDecorator extends FoodDecorator {
    private String sauceName;
    private double saucePrice;
    
    public SauceDecorator(Food food, String sauceName, double saucePrice) {
        super(food);
        this.sauceName = sauceName;
        this.saucePrice = saucePrice;
    }
    
    // Factory methods for common sauces
    public static SauceDecorator bbqSauce(Food food) {
        return new SauceDecorator(food, "BBQ Sauce", 15.0);
    }
    
    public static SauceDecorator garlicMayo(Food food) {
        return new SauceDecorator(food, "Garlic Mayo", 20.0);
    }
    
    public static SauceDecorator hotSauce(Food food) {
        return new SauceDecorator(food, "Hot Sauce", 10.0);
    }
    
    public static SauceDecorator pesto(Food food) {
        return new SauceDecorator(food, "Pesto", 25.0);
    }
    
    @Override
    public String getDescription() {
        return decoratedFood.getDescription() + " + " + sauceName;
    }
    
    @Override
    public double getPrice() {
        return decoratedFood.getPrice() + saucePrice;
    }
}

