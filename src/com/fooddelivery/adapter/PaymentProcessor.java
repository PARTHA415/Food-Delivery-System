package com.fooddelivery.adapter;

/**
 * Target interface that our system expects
 */
public interface PaymentProcessor {
    boolean processPayment(String orderId, double amount, String customerId);
    boolean refundPayment(String transactionId, double amount);
    String getPaymentStatus(String transactionId);
    void displayPaymentDetails(String transactionId);
}

