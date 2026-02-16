package com.fooddelivery.decorator;

/**
 * Abstract Decorator class
 */
public abstract class FoodDecorator implements Food {
    protected Food decoratedFood;
    
    public FoodDecorator(Food food) {
        this.decoratedFood = food;
    }
    
    @Override
    public String getDescription() {
        return decoratedFood.getDescription();
    }
    
    @Override
    public double getPrice() {
        return decoratedFood.getPrice();
    }
    
    @Override
    public String getItemName() {
        return decoratedFood.getItemName();
    }
}

