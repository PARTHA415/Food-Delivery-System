package com.fooddelivery.strategy;

/**
 * Standard delivery fee - flat rate + per km charge
 */
public class StandardDeliveryStrategy implements DeliveryFeeStrategy {
    private static final double BASE_FEE = 30.0;
    private static final double PER_KM_CHARGE = 5.0;
    
    @Override
    public double calculateFee(double distance, double orderAmount) {
        return BASE_FEE + (distance * PER_KM_CHARGE);
    }
    
    @Override
    public String getStrategyName() {
        return "Standard Delivery";
    }
    
    @Override
    public String getDescription() {
        return "Base ₹" + BASE_FEE + " + ₹" + PER_KM_CHARGE + "/km";
    }
}

