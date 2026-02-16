package com.fooddelivery.observer;

/**
 * Concrete Observer - Restaurant notification
 */
public class RestaurantNotificationObserver implements OrderObserver {
    private String restaurantId;
    private String restaurantName;
    
    public RestaurantNotificationObserver(String restaurantId, String restaurantName) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
    }
    
    @Override
    public void update(OrderEvent event) {
        String notification = buildNotification(event);
        if (notification != null) {
            System.out.println("  🏪 [RESTAURANT → " + restaurantName + "] " + notification);
        }
    }
    
    private String buildNotification(OrderEvent event) {
        switch (event.getStatus()) {
            case ORDER_PLACED:
                return "🔔 New order received! Order #" + event.getOrderId();
            case ORDER_CONFIRMED:
                return "✅ Order confirmed. Start preparing!";
            case READY_FOR_PICKUP:
                return "📦 Order packed. Waiting for delivery partner.";
            case OUT_FOR_DELIVERY:
                return "🛵 " + event.getDeliveryPersonName() + " picked up the order.";
            case DELIVERED:
                return "✅ Order delivered successfully!";
            case CANCELLED:
                return "❌ Order cancelled: " + event.getMessage();
            default:
                return null;
        }
    }
    
    @Override
    public String getObserverName() {
        return "RestaurantNotification(" + restaurantName + ")";
    }
}

