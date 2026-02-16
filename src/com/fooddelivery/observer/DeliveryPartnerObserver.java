package com.fooddelivery.observer;

/**
 * Concrete Observer - Delivery partner notification
 */
public class DeliveryPartnerObserver implements OrderObserver {
    private String partnerId;
    private String partnerName;
    private String vehicleNumber;
    
    public DeliveryPartnerObserver(String partnerId, String partnerName, String vehicleNumber) {
        this.partnerId = partnerId;
        this.partnerName = partnerName;
        this.vehicleNumber = vehicleNumber;
    }
    
    @Override
    public void update(OrderEvent event) {
        String notification = buildNotification(event);
        if (notification != null) {
            System.out.println("  🛵 [DELIVERY PARTNER → " + partnerName + "] " + notification);
        }
    }
    
    private String buildNotification(OrderEvent event) {
        switch (event.getStatus()) {
            case READY_FOR_PICKUP:
                return "🔔 Order ready! Head to restaurant for pickup.";
            case OUT_FOR_DELIVERY:
                return "📍 Navigate to customer location. ETA: " + event.getEstimatedMinutes() + " mins";
            case DELIVERED:
                return "💰 Delivery completed! Earnings credited.";
            case CANCELLED:
                return "❌ Order cancelled. Return to hub.";
            default:
                return null;
        }
    }
    
    @Override
    public String getObserverName() {
        return "DeliveryPartner(" + partnerName + " - " + vehicleNumber + ")";
    }
    
    public String getPartnerName() {
        return partnerName;
    }
}

