package com.fooddelivery.observer;

/**
 * Event object for order tracking
 */
public class OrderEvent {
    private String orderId;
    private OrderStatus status;
    private String message;
    private long timestamp;
    private String deliveryPersonName;
    private String location;
    private int estimatedMinutes;
    
    public enum OrderStatus {
        ORDER_PLACED,
        ORDER_CONFIRMED,
        PREPARING,
        READY_FOR_PICKUP,
        OUT_FOR_DELIVERY,
        DELIVERED,
        CANCELLED
    }
    
    public OrderEvent(String orderId, OrderStatus status, String message) {
        this.orderId = orderId;
        this.status = status;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }
    
    public OrderEvent withDeliveryPerson(String name) {
        this.deliveryPersonName = name;
        return this;
    }
    
    public OrderEvent withLocation(String location) {
        this.location = location;
        return this;
    }
    
    public OrderEvent withETA(int minutes) {
        this.estimatedMinutes = minutes;
        return this;
    }
    
    // Getters
    public String getOrderId() { return orderId; }
    public OrderStatus getStatus() { return status; }
    public String getMessage() { return message; }
    public long getTimestamp() { return timestamp; }
    public String getDeliveryPersonName() { return deliveryPersonName; }
    public String getLocation() { return location; }
    public int getEstimatedMinutes() { return estimatedMinutes; }
}

