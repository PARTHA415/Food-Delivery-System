package com.fooddelivery.strategy;

/**
 * Context class for delivery fee calculation
 */
public class DeliveryFeeCalculator {
    private DeliveryFeeStrategy strategy;
    
    public DeliveryFeeCalculator() {
        // Default strategy
        this.strategy = new StandardDeliveryStrategy();
    }
    
    public DeliveryFeeCalculator(DeliveryFeeStrategy strategy) {
        this.strategy = strategy;
    }
    
    public void setStrategy(DeliveryFeeStrategy strategy) {
        this.strategy = strategy;
    }
    
    public DeliveryFeeStrategy getStrategy() {
        return strategy;
    }
    
    public double calculateDeliveryFee(double distance, double orderAmount) {
        return strategy.calculateFee(distance, orderAmount);
    }
    
    public void displayFeeDetails(double distance, double orderAmount) {
        double fee = calculateDeliveryFee(distance, orderAmount);
        
        System.out.println("===========================================");
        System.out.println("DELIVERY FEE CALCULATION - " + strategy.getStrategyName().toUpperCase());
        System.out.println("===========================================");
        System.out.println("  Strategy: " + strategy.getDescription());
        System.out.println("  Distance: " + distance + " km");
        System.out.println("  Order Amount: ₹" + String.format("%.2f", orderAmount));
        System.out.println("  Delivery Fee: ₹" + String.format("%.2f", fee));
        System.out.println("===========================================");
    }
}

