package com.fooddelivery.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Subject/Publisher that manages order tracking updates
 */
public class OrderTracker {
    private List<OrderObserver> observers = new ArrayList<>();
    private String orderId;
    private OrderEvent.OrderStatus currentStatus;
    
    public OrderTracker(String orderId) {
        this.orderId = orderId;
        this.currentStatus = OrderEvent.OrderStatus.ORDER_PLACED;
    }
    
    public void subscribe(OrderObserver observer) {
        observers.add(observer);
        System.out.println("[TRACKER] Subscribed: " + observer.getObserverName());
    }
    
    public void unsubscribe(OrderObserver observer) {
        observers.remove(observer);
        System.out.println("[TRACKER] Unsubscribed: " + observer.getObserverName());
    }
    
    public void notifyObservers(OrderEvent event) {
        System.out.println("\n[TRACKER] Broadcasting " + event.getStatus() + " event...");
        for (OrderObserver observer : observers) {
            observer.update(event);
        }
    }
    
    // Status update methods
    public void orderPlaced() {
        OrderEvent event = new OrderEvent(orderId, OrderEvent.OrderStatus.ORDER_PLACED, 
            "Your order has been placed successfully!");
        currentStatus = OrderEvent.OrderStatus.ORDER_PLACED;
        notifyObservers(event);
    }
    
    public void orderConfirmed(int estimatedMinutes) {
        OrderEvent event = new OrderEvent(orderId, OrderEvent.OrderStatus.ORDER_CONFIRMED, 
            "Restaurant has confirmed your order!")
            .withETA(estimatedMinutes);
        currentStatus = OrderEvent.OrderStatus.ORDER_CONFIRMED;
        notifyObservers(event);
    }
    
    public void preparingOrder() {
        OrderEvent event = new OrderEvent(orderId, OrderEvent.OrderStatus.PREPARING, 
            "Chef is preparing your delicious food!");
        currentStatus = OrderEvent.OrderStatus.PREPARING;
        notifyObservers(event);
    }
    
    public void readyForPickup() {
        OrderEvent event = new OrderEvent(orderId, OrderEvent.OrderStatus.READY_FOR_PICKUP, 
            "Your order is packed and ready for pickup!");
        currentStatus = OrderEvent.OrderStatus.READY_FOR_PICKUP;
        notifyObservers(event);
    }
    
    public void outForDelivery(String deliveryPersonName, String location, int etaMinutes) {
        OrderEvent event = new OrderEvent(orderId, OrderEvent.OrderStatus.OUT_FOR_DELIVERY, 
            "Your order is on the way!")
            .withDeliveryPerson(deliveryPersonName)
            .withLocation(location)
            .withETA(etaMinutes);
        currentStatus = OrderEvent.OrderStatus.OUT_FOR_DELIVERY;
        notifyObservers(event);
    }
    
    public void delivered() {
        OrderEvent event = new OrderEvent(orderId, OrderEvent.OrderStatus.DELIVERED, 
            "Your order has been delivered. Enjoy your meal!");
        currentStatus = OrderEvent.OrderStatus.DELIVERED;
        notifyObservers(event);
    }
    
    public void cancelled(String reason) {
        OrderEvent event = new OrderEvent(orderId, OrderEvent.OrderStatus.CANCELLED, 
            "Order cancelled: " + reason);
        currentStatus = OrderEvent.OrderStatus.CANCELLED;
        notifyObservers(event);
    }
    
    public OrderEvent.OrderStatus getCurrentStatus() {
        return currentStatus;
    }
    
    public String getOrderId() {
        return orderId;
    }
}

