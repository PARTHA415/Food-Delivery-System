package com.fooddelivery.observer;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Concrete Observer - Analytics and logging
 */
public class AnalyticsObserver implements OrderObserver {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Override
    public void update(OrderEvent event) {
        String timestamp = dateFormat.format(new Date(event.getTimestamp()));
        System.out.println("  📊 [ANALYTICS] " + timestamp + " | Order: " + event.getOrderId() + 
            " | Status: " + event.getStatus() + " | " + event.getMessage());
    }
    
    @Override
    public String getObserverName() {
        return "AnalyticsObserver";
    }
}

