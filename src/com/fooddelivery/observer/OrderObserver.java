package com.fooddelivery.observer;

/**
 * Observer interface for order tracking updates
 */
public interface OrderObserver {
    void update(OrderEvent event);
    String getObserverName();
}

