package com.fooddelivery.decorator;

/**
 * Concrete Decorator - Toppings (various options)
 */
public class ToppingDecorator extends FoodDecorator {
    private String toppingName;
    private double toppingPrice;
    private String emoji;
    
    public ToppingDecorator(Food food, String toppingName, double toppingPrice, String emoji) {
        super(food);
        this.toppingName = toppingName;
        this.toppingPrice = toppingPrice;
        this.emoji = emoji;
    }
    
    // Factory methods for common toppings
    public static ToppingDecorator mushrooms(Food food) {
        return new ToppingDecorator(food, "Mushrooms", 35.0, "🍄");
    }
    
    public static ToppingDecorator olives(Food food) {
        return new ToppingDecorator(food, "Olives", 30.0, "🫒");
    }
    
    public static ToppingDecorator jalapenos(Food food) {
        return new ToppingDecorator(food, "Jalapenos", 25.0, "🌶️");
    }
    
    public static ToppingDecorator onions(Food food) {
        return new ToppingDecorator(food, "Onions", 20.0, "🧅");
    }
    
    public static ToppingDecorator pepperoni(Food food) {
        return new ToppingDecorator(food, "Pepperoni", 50.0, "🥓");
    }
    
    @Override
    public String getDescription() {
        return decoratedFood.getDescription() + " + " + toppingName + " " + emoji;
    }
    
    @Override
    public double getPrice() {
        return decoratedFood.getPrice() + toppingPrice;
    }
}

