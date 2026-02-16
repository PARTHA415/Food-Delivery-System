package com.fooddelivery.observer;

/**
 * Concrete Observer - Customer notification via SMS/App
 */
public class CustomerNotificationObserver implements OrderObserver {
    private String customerId;
    private String customerName;
    private String phoneNumber;
    
    public CustomerNotificationObserver(String customerId, String customerName, String phoneNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public void update(OrderEvent event) {
        String notification = buildNotification(event);
        System.out.println("  📱 [CUSTOMER SMS → " + phoneNumber + "] " + notification);
    }
    
    private String buildNotification(OrderEvent event) {
        StringBuilder sb = new StringBuilder();
        sb.append("Hi ").append(customerName).append("! ");
        
        switch (event.getStatus()) {
            case ORDER_PLACED:
                sb.append("Order #").append(event.getOrderId()).append(" placed successfully!");
                break;
            case ORDER_CONFIRMED:
                sb.append("Order confirmed! ETA: ").append(event.getEstimatedMinutes()).append(" mins");
                break;
            case PREPARING:
                sb.append("Your food is being prepared 👨‍🍳");
                break;
            case READY_FOR_PICKUP:
                sb.append("Your order is packed and waiting for delivery partner!");
                break;
            case OUT_FOR_DELIVERY:
                sb.append(event.getDeliveryPersonName()).append(" is on the way! ETA: ")
                  .append(event.getEstimatedMinutes()).append(" mins 🛵");
                break;
            case DELIVERED:
                sb.append("Order delivered! Enjoy your meal! 🍽️ Rate your experience.");
                break;
            case CANCELLED:
                sb.append("Order cancelled. ").append(event.getMessage());
                break;
        }
        
        return sb.toString();
    }
    
    @Override
    public String getObserverName() {
        return "CustomerNotification(" + customerId + ")";
    }
}

