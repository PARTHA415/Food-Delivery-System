package com.fooddelivery.strategy;

/**
 * Night delivery with additional charges
 */
public class NightDeliveryStrategy implements DeliveryFeeStrategy {
    private static final double NIGHT_BASE_FEE = 60.0;
    private static final double PER_KM_CHARGE = 7.0;
    private static final double NIGHT_SURCHARGE = 20.0;
    
    @Override
    public double calculateFee(double distance, double orderAmount) {
        return NIGHT_BASE_FEE + (distance * PER_KM_CHARGE) + NIGHT_SURCHARGE;
    }
    
    @Override
    public String getStrategyName() {
        return "Night Delivery (10 PM - 6 AM)";
    }
    
    @Override
    public String getDescription() {
        return "Night surcharge ₹" + NIGHT_SURCHARGE + " + Base ₹" + NIGHT_BASE_FEE + " + ₹" + PER_KM_CHARGE + "/km";
    }
}

