package com.fooddelivery.strategy;

/**
 * Free delivery for orders above threshold
 */
public class FreeDeliveryStrategy implements DeliveryFeeStrategy {
    private static final double FREE_DELIVERY_THRESHOLD = 500.0;
    private static final double SMALL_ORDER_FEE = 40.0;
    
    @Override
    public double calculateFee(double distance, double orderAmount) {
        if (orderAmount >= FREE_DELIVERY_THRESHOLD) {
            return 0.0;
        }
        return SMALL_ORDER_FEE;
    }
    
    @Override
    public String getStrategyName() {
        return "Free Delivery (Above ₹" + FREE_DELIVERY_THRESHOLD + ")";
    }
    
    @Override
    public String getDescription() {
        return "Free for orders ≥ ₹" + FREE_DELIVERY_THRESHOLD + ", else ₹" + SMALL_ORDER_FEE + " flat";
    }
}

