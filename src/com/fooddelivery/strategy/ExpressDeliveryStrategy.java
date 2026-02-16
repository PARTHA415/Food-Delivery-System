package com.fooddelivery.strategy;

/**
 * Express delivery - premium fast delivery with surge pricing
 */
public class ExpressDeliveryStrategy implements DeliveryFeeStrategy {
    private static final double EXPRESS_BASE_FEE = 50.0;
    private static final double PER_KM_CHARGE = 8.0;
    private static final double SURGE_MULTIPLIER = 1.5;
    
    @Override
    public double calculateFee(double distance, double orderAmount) {
        double baseFee = EXPRESS_BASE_FEE + (distance * PER_KM_CHARGE);
        return baseFee * SURGE_MULTIPLIER;
    }
    
    @Override
    public String getStrategyName() {
        return "Express Delivery";
    }
    
    @Override
    public String getDescription() {
        return "Fast delivery with " + SURGE_MULTIPLIER + "x surge (Base ₹" + EXPRESS_BASE_FEE + " + ₹" + PER_KM_CHARGE + "/km)";
    }
}

