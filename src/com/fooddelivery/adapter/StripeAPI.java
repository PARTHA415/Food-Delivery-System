package com.fooddelivery.adapter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Third-party Stripe API (Adaptee)
 * Another external payment service with different interface
 */
public class StripeAPI {
    private Map<String, StripeCharge> charges = new HashMap<>();
    
    // Stripe uses Charge objects
    public StripeCharge createCharge(int amountInCents, String currency, String customerToken, String description) {
        String chargeId = "ch_" + UUID.randomUUID().toString().substring(0, 12);
        StripeCharge charge = new StripeCharge(chargeId, amountInCents, currency, customerToken, description);
        charges.put(chargeId, charge);
        
        System.out.println("    [Stripe API] Charge created");
        System.out.println("    [Stripe API] Charge ID: " + chargeId);
        System.out.println("    [Stripe API] Amount: " + amountInCents + " " + currency.toUpperCase());
        
        return charge;
    }
    
    public StripeRefund createRefund(String chargeId, int refundAmountCents) {
        StripeCharge charge = charges.get(chargeId);
        if (charge != null && charge.status.equals("succeeded")) {
            charge.status = "refunded";
            String refundId = "re_" + UUID.randomUUID().toString().substring(0, 12);
            System.out.println("    [Stripe API] Refund created: " + refundId);
            return new StripeRefund(refundId, chargeId, refundAmountCents, "succeeded");
        }
        return null;
    }
    
    public StripeCharge retrieveCharge(String chargeId) {
        return charges.get(chargeId);
    }
    
    // Stripe's Charge object
    public static class StripeCharge {
        public String id;
        public int amount;
        public String currency;
        public String customer;
        public String description;
        public String status;
        
        public StripeCharge(String id, int amount, String currency, String customer, String description) {
            this.id = id;
            this.amount = amount;
            this.currency = currency;
            this.customer = customer;
            this.description = description;
            this.status = "succeeded";
        }
    }
    
    // Stripe's Refund object
    public static class StripeRefund {
        public String id;
        public String chargeId;
        public int amount;
        public String status;
        
        public StripeRefund(String id, String chargeId, int amount, String status) {
            this.id = id;
            this.chargeId = chargeId;
            this.amount = amount;
            this.status = status;
        }
    }
}

