package com.fooddelivery.adapter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Third-party PayPal API (Adaptee)
 * This represents an external payment service with its own interface
 */
public class PayPalAPI {
    private Map<String, PayPalTransaction> transactions = new HashMap<>();
    
    // PayPal uses different method signatures
    public String makePayment(double amountUSD, String merchantId, String buyerEmail) {
        String paypalTxnId = "PP-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        PayPalTransaction txn = new PayPalTransaction(paypalTxnId, amountUSD, merchantId, buyerEmail, "COMPLETED");
        transactions.put(paypalTxnId, txn);
        
        System.out.println("    [PayPal API] Payment processed");
        System.out.println("    [PayPal API] Transaction ID: " + paypalTxnId);
        System.out.println("    [PayPal API] Amount: $" + String.format("%.2f", amountUSD));
        
        return paypalTxnId;
    }
    
    public boolean initiateRefund(String paypalTxnId, double refundAmount) {
        PayPalTransaction txn = transactions.get(paypalTxnId);
        if (txn != null && txn.status.equals("COMPLETED")) {
            txn.status = "REFUNDED";
            System.out.println("    [PayPal API] Refund initiated for: " + paypalTxnId);
            return true;
        }
        return false;
    }
    
    public String checkStatus(String paypalTxnId) {
        PayPalTransaction txn = transactions.get(paypalTxnId);
        return txn != null ? txn.status : "NOT_FOUND";
    }
    
    public PayPalTransaction getTransaction(String paypalTxnId) {
        return transactions.get(paypalTxnId);
    }
    
    // PayPal's transaction structure
    public static class PayPalTransaction {
        public String transactionId;
        public double amount;
        public String merchantId;
        public String buyerEmail;
        public String status;
        
        public PayPalTransaction(String transactionId, double amount, String merchantId, String buyerEmail, String status) {
            this.transactionId = transactionId;
            this.amount = amount;
            this.merchantId = merchantId;
            this.buyerEmail = buyerEmail;
            this.status = status;
        }
    }
}

