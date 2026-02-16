package com.fooddelivery.decorator;

/**
 * Concrete Decorator - Extra Cheese
 */
public class ExtraCheeseDecorator extends FoodDecorator {
    private static final double EXTRA_CHEESE_PRICE = 40.0;
    
    public ExtraCheeseDecorator(Food food) {
        super(food);
    }
    
    @Override
    public String getDescription() {
        return decoratedFood.getDescription() + " + Extra Cheese 🧀";
    }
    
    @Override
    public double getPrice() {
        return decoratedFood.getPrice() + EXTRA_CHEESE_PRICE;
    }
}

