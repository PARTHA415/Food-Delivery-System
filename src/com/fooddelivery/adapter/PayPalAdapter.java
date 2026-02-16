package com.fooddelivery.adapter;

import java.util.HashMap;
import java.util.Map;

/**
 * Adapter for PayPal API
 * Adapts PayPal's interface to our PaymentProcessor interface
 */
public class PayPalAdapter implements PaymentProcessor {
    private PayPalAPI paypal;
    private Map<String, String> orderToTxnMap = new HashMap<>();
    private static final double INR_TO_USD = 0.012; // Conversion rate
    private static final String MERCHANT_ID = "FOOD_DELIVERY_MERCHANT";
    
    public PayPalAdapter() {
        this.paypal = new PayPalAPI();
    }
    
    public PayPalAdapter(PayPalAPI paypal) {
        this.paypal = paypal;
    }
    
    @Override
    public boolean processPayment(String orderId, double amount, String customerId) {
        // Convert INR to USD for PayPal
        double amountUSD = amount * INR_TO_USD;
        String buyerEmail = customerId + "@example.com";
        
        System.out.println("\n  [PayPal Adapter] Converting ₹" + amount + " to $" + String.format("%.2f", amountUSD));
        
        String txnId = paypal.makePayment(amountUSD, MERCHANT_ID, buyerEmail);
        
        if (txnId != null) {
            orderToTxnMap.put(orderId, txnId);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean refundPayment(String transactionId, double amount) {
        double amountUSD = amount * INR_TO_USD;
        return paypal.initiateRefund(transactionId, amountUSD);
    }
    
    @Override
    public String getPaymentStatus(String transactionId) {
        return paypal.checkStatus(transactionId);
    }
    
    @Override
    public void displayPaymentDetails(String transactionId) {
        PayPalAPI.PayPalTransaction txn = paypal.getTransaction(transactionId);
        if (txn != null) {
            System.out.println("  ╔════════════════════════════════════════╗");
            System.out.println("  ║       PAYPAL PAYMENT RECEIPT           ║");
            System.out.println("  ╠════════════════════════════════════════╣");
            System.out.println("  ║  Transaction ID: " + txn.transactionId + "       ║");
            System.out.println("  ║  Amount: $" + String.format("%.2f", txn.amount) + "                        ║");
            System.out.println("  ║  Status: " + txn.status + "                    ║");
            System.out.println("  ║  Buyer: " + txn.buyerEmail + "        ║");
            System.out.println("  ╚════════════════════════════════════════╝");
        }
    }
    
    public String getTransactionId(String orderId) {
        return orderToTxnMap.get(orderId);
    }
}

