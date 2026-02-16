package com.fooddelivery.strategy;

/**
 * Strategy interface for delivery fee calculation
 */
public interface DeliveryFeeStrategy {
    double calculateFee(double distance, double orderAmount);
    String getStrategyName();
    String getDescription();
}

