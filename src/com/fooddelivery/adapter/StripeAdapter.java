package com.fooddelivery.adapter;

import java.util.HashMap;
import java.util.Map;

/**
 * Adapter for Stripe API
 * Adapts Stripe's interface to our PaymentProcessor interface
 */
public class StripeAdapter implements PaymentProcessor {
    private StripeAPI stripe;
    private Map<String, String> orderToChargeMap = new HashMap<>();
    private static final String CURRENCY = "inr";
    
    public StripeAdapter() {
        this.stripe = new StripeAPI();
    }
    
    public StripeAdapter(StripeAPI stripe) {
        this.stripe = stripe;
    }
    
    @Override
    public boolean processPayment(String orderId, double amount, String customerId) {
        // Stripe uses cents/paise
        int amountInPaise = (int) (amount * 100);
        String customerToken = "cus_" + customerId;
        String description = "Food Order: " + orderId;
        
        System.out.println("\n  [Stripe Adapter] Processing ₹" + amount + " (" + amountInPaise + " paise)");
        
        StripeAPI.StripeCharge charge = stripe.createCharge(amountInPaise, CURRENCY, customerToken, description);
        
        if (charge != null) {
            orderToChargeMap.put(orderId, charge.id);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean refundPayment(String transactionId, double amount) {
        int amountInPaise = (int) (amount * 100);
        StripeAPI.StripeRefund refund = stripe.createRefund(transactionId, amountInPaise);
        return refund != null;
    }
    
    @Override
    public String getPaymentStatus(String transactionId) {
        StripeAPI.StripeCharge charge = stripe.retrieveCharge(transactionId);
        return charge != null ? charge.status.toUpperCase() : "NOT_FOUND";
    }
    
    @Override
    public void displayPaymentDetails(String transactionId) {
        StripeAPI.StripeCharge charge = stripe.retrieveCharge(transactionId);
        if (charge != null) {
            double amountInRupees = charge.amount / 100.0;
            System.out.println("  ╔════════════════════════════════════════╗");
            System.out.println("  ║        STRIPE PAYMENT RECEIPT          ║");
            System.out.println("  ╠════════════════════════════════════════╣");
            System.out.println("  ║  Charge ID: " + charge.id + "     ║");
            System.out.println("  ║  Amount: ₹" + String.format("%.2f", amountInRupees) + "                       ║");
            System.out.println("  ║  Currency: " + charge.currency.toUpperCase() + "                         ║");
            System.out.println("  ║  Status: " + charge.status.toUpperCase() + "                    ║");
            System.out.println("  ║  Description: " + charge.description + "    ║");
            System.out.println("  ╚════════════════════════════════════════╝");
        }
    }
    
    public String getChargeId(String orderId) {
        return orderToChargeMap.get(orderId);
    }
}

