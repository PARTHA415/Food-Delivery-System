package com.fooddelivery;

import com.fooddelivery.abstractfactory.*;
import com.fooddelivery.composite.*;
import com.fooddelivery.strategy.*;
import com.fooddelivery.decorator.*;
import com.fooddelivery.adapter.*;
import com.fooddelivery.observer.*;

/**
 * Main demonstration class for Food Delivery System
 * Showcases 6 different design patterns
 */
public class Main {
    
    public static void main(String[] args) {
        printHeader();
        
        // 1. Abstract Factory Pattern
        demonstrateAbstractFactory();
        
        // 2. Composite Pattern
        demonstrateComposite();
        
        // 3. Strategy Pattern
        demonstrateStrategy();
        
        // 4. Decorator Pattern
        demonstrateDecorator();
        
        // 5. Adapter Pattern
        demonstrateAdapter();
        
        // 6. Observer Pattern
        demonstrateObserver();
        
        printFooter();
    }
    
    private static void printHeader() {
        System.out.println("============================================================");
        System.out.println("         FOOD DELIVERY SYSTEM - DEMO");
        System.out.println("         Design Patterns Demonstration");
        System.out.println("============================================================");
    }
    
    private static void printFooter() {
        System.out.println("\n============================================================");
        System.out.println("              DEMO COMPLETED SUCCESSFULLY");
        System.out.println("============================================================");
    }
    
    // ========== 1. ABSTRACT FACTORY PATTERN ==========
    private static void demonstrateAbstractFactory() {
        System.out.println("\n\n============================================================");
        System.out.println("  [1] ABSTRACT FACTORY PATTERN - Restaurant UI/Menu Providers");
        System.out.println("============================================================");
        
        // Create different restaurant factories
        RestaurantFactory[] factories = {
            new ItalianRestaurantFactory(),
            new IndianRestaurantFactory(),
            new ChineseRestaurantFactory()
        };
        
        for (RestaurantFactory factory : factories) {
            System.out.println("\n─────────────────────────────────────────");
            
            // Create UI using factory
            RestaurantUI ui = factory.createUI();
            ui.renderUI();
            
            // Create menu provider using factory
            MenuProvider menuProvider = factory.createMenuProvider();
            menuProvider.displayMenu();
            
            // Create signature dish using factory
            MenuItem signature = factory.createSignatureDish();
            System.out.println("\n  ⭐ SIGNATURE DISH:");
            signature.display();
        }
    }
    
    // ========== 2. COMPOSITE PATTERN ==========
    private static void demonstrateComposite() {
        System.out.println("\n\n============================================================");
        System.out.println("  [2] COMPOSITE PATTERN - Menu → Category → Items");
        System.out.println("============================================================");
        
        // Create menu structure
        Menu restaurantMenu = new Menu("Foodie's Paradise");
        
        // Appetizers category
        MenuCategory appetizers = new MenuCategory("Appetizers", "Start your meal right");
        appetizers.add(new FoodItem("Spring Rolls", "Crispy vegetable rolls", 120.0, true, "MILD"));
        appetizers.add(new FoodItem("Chicken Wings", "Spicy buffalo wings", 180.0, false, "HOT"));
        appetizers.add(new FoodItem("Garlic Bread", "Toasted bread with garlic butter", 90.0, true));
        
        // Main Course category with sub-categories
        MenuCategory mainCourse = new MenuCategory("Main Course", "Hearty and fulfilling");
        
        // Sub-category: Vegetarian
        MenuCategory vegSection = new MenuCategory("Vegetarian", "Plant-based delights");
        vegSection.add(new FoodItem("Paneer Butter Masala", "Cottage cheese in rich tomato gravy", 250.0, true, "MEDIUM"));
        vegSection.add(new FoodItem("Veg Biryani", "Fragrant rice with mixed vegetables", 220.0, true, "MEDIUM"));
        vegSection.add(new FoodItem("Mushroom Risotto", "Creamy Italian rice with mushrooms", 280.0, true));
        
        // Sub-category: Non-Vegetarian
        MenuCategory nonVegSection = new MenuCategory("Non-Vegetarian", "For meat lovers");
        nonVegSection.add(new FoodItem("Butter Chicken", "Tender chicken in creamy tomato sauce", 320.0, false, "MEDIUM"));
        nonVegSection.add(new FoodItem("Lamb Rogan Josh", "Kashmiri style lamb curry", 380.0, false, "HOT"));
        nonVegSection.add(new FoodItem("Grilled Salmon", "Fresh salmon with herbs", 450.0, false));
        
        mainCourse.add(vegSection);
        mainCourse.add(nonVegSection);
        
        // Desserts category
        MenuCategory desserts = new MenuCategory("Desserts", "Sweet endings");
        desserts.add(new FoodItem("Chocolate Lava Cake", "Warm chocolate cake with molten center", 180.0, true));
        desserts.add(new FoodItem("Gulab Jamun", "Deep-fried milk dumplings in syrup", 120.0, true));
        desserts.add(new FoodItem("Ice Cream Sundae", "Assorted ice cream with toppings", 150.0, true));
        
        // Beverages
        MenuCategory beverages = new MenuCategory("Beverages", "Refreshing drinks");
        beverages.add(new FoodItem("Fresh Lime Soda", "Tangy and refreshing", 60.0, true));
        beverages.add(new FoodItem("Mango Lassi", "Sweet yogurt drink with mango", 90.0, true));
        beverages.add(new FoodItem("Cold Coffee", "Chilled coffee with ice cream", 110.0, true));
        
        // Add all categories to menu
        restaurantMenu.add(appetizers);
        restaurantMenu.add(mainCourse);
        restaurantMenu.add(desserts);
        restaurantMenu.add(beverages);
        
        // Display complete menu hierarchy
        restaurantMenu.display(0);
        
        System.out.println("\n📊 Menu Statistics:");
        System.out.println("  Total items in menu: " + restaurantMenu.getItemCount());
        System.out.println("  Items in Main Course: " + mainCourse.getItemCount());
        System.out.println("  Items in Vegetarian section: " + vegSection.getItemCount());
    }
    
    // ========== 3. STRATEGY PATTERN ==========
    private static void demonstrateStrategy() {
        System.out.println("\n\n============================================================");
        System.out.println("  [3] STRATEGY PATTERN - Delivery Fee Calculation");
        System.out.println("============================================================");
        
        double distance = 5.0; // km
        double orderAmount = 450.0; // INR
        
        System.out.println("\nOrder details: Distance = " + distance + " km, Order Amount = ₹" + orderAmount);
        
        DeliveryFeeCalculator calculator = new DeliveryFeeCalculator();
        
        // Standard delivery
        System.out.println();
        calculator.setStrategy(new StandardDeliveryStrategy());
        calculator.displayFeeDetails(distance, orderAmount);
        
        // Express delivery
        System.out.println();
        calculator.setStrategy(new ExpressDeliveryStrategy());
        calculator.displayFeeDetails(distance, orderAmount);
        
        // Night delivery
        System.out.println();
        calculator.setStrategy(new NightDeliveryStrategy());
        calculator.displayFeeDetails(distance, orderAmount);
        
        // Free delivery (order below threshold)
        System.out.println();
        calculator.setStrategy(new FreeDeliveryStrategy());
        calculator.displayFeeDetails(distance, orderAmount);
        
        // Free delivery (order above threshold)
        System.out.println();
        calculator.displayFeeDetails(distance, 600.0);
    }
    
    // ========== 4. DECORATOR PATTERN ==========
    private static void demonstrateDecorator() {
        System.out.println("\n\n============================================================");
        System.out.println("  [4] DECORATOR PATTERN - Add-ons (Extra Cheese, Toppings)");
        System.out.println("============================================================");
        
        // Base pizza
        System.out.println("\n--- Building a Custom Pizza ---\n");
        
        Food pizza = new Pizza("Margherita Pizza", "Medium", 250.0);
        System.out.println("Base: " + pizza.getDescription());
        System.out.println("Price: ₹" + pizza.getPrice());
        
        // Add extra cheese
        System.out.println("\n+ Adding Extra Cheese...");
        pizza = new ExtraCheeseDecorator(pizza);
        System.out.println("Current: " + pizza.getDescription());
        System.out.println("Price: ₹" + pizza.getPrice());
        
        // Add mushrooms
        System.out.println("\n+ Adding Mushrooms...");
        pizza = ToppingDecorator.mushrooms(pizza);
        System.out.println("Current: " + pizza.getDescription());
        System.out.println("Price: ₹" + pizza.getPrice());
        
        // Add jalapenos
        System.out.println("\n+ Adding Jalapenos...");
        pizza = ToppingDecorator.jalapenos(pizza);
        System.out.println("Current: " + pizza.getDescription());
        System.out.println("Price: ₹" + pizza.getPrice());
        
        // Add BBQ sauce
        System.out.println("\n+ Adding BBQ Sauce...");
        pizza = SauceDecorator.bbqSauce(pizza);
        
        // Final order
        System.out.println("\n═══════════════════════════════════════════════");
        System.out.println("  FINAL ORDER");
        System.out.println("═══════════════════════════════════════════════");
        System.out.println("  Item: " + pizza.getDescription());
        System.out.println("  Total Price: ₹" + pizza.getPrice());
        System.out.println("═══════════════════════════════════════════════");
        
        // Another example with burger
        System.out.println("\n--- Building a Custom Burger ---\n");
        
        Food burger = new Burger("Classic Burger", "Veg", 150.0);
        burger = new ExtraCheeseDecorator(burger);
        burger = ToppingDecorator.onions(burger);
        burger = ToppingDecorator.jalapenos(burger);
        burger = SauceDecorator.garlicMayo(burger);
        
        System.out.println("═══════════════════════════════════════════════");
        System.out.println("  FINAL ORDER");
        System.out.println("═══════════════════════════════════════════════");
        System.out.println("  Item: " + burger.getDescription());
        System.out.println("  Total Price: ₹" + burger.getPrice());
        System.out.println("═══════════════════════════════════════════════");
    }
    
    // ========== 5. ADAPTER PATTERN ==========
    private static void demonstrateAdapter() {
        System.out.println("\n\n============================================================");
        System.out.println("  [5] ADAPTER PATTERN - Third-Party Payment Gateway");
        System.out.println("============================================================");
        
        String orderId = "ORD-2024-001";
        double amount = 565.0;
        String customerId = "CUST-123";
        
        System.out.println("\nOrder: " + orderId + " | Amount: ₹" + amount);
        
        // Using PayPal Adapter
        System.out.println("\n─────────────────────────────────────────");
        System.out.println("Payment via PayPal (adapted):");
        System.out.println("─────────────────────────────────────────");
        
        PaymentProcessor paypalProcessor = new PayPalAdapter();
        boolean paypalSuccess = paypalProcessor.processPayment(orderId, amount, customerId);
        System.out.println("\n  Payment Success: " + paypalSuccess);
        
        String paypalTxnId = ((PayPalAdapter) paypalProcessor).getTransactionId(orderId);
        System.out.println("  Status: " + paypalProcessor.getPaymentStatus(paypalTxnId));
        paypalProcessor.displayPaymentDetails(paypalTxnId);
        
        // Using Stripe Adapter
        System.out.println("\n─────────────────────────────────────────");
        System.out.println("Payment via Stripe (adapted):");
        System.out.println("─────────────────────────────────────────");
        
        String orderId2 = "ORD-2024-002";
        PaymentProcessor stripeProcessor = new StripeAdapter();
        boolean stripeSuccess = stripeProcessor.processPayment(orderId2, amount, customerId);
        System.out.println("\n  Payment Success: " + stripeSuccess);
        
        String chargeId = ((StripeAdapter) stripeProcessor).getChargeId(orderId2);
        System.out.println("  Status: " + stripeProcessor.getPaymentStatus(chargeId));
        stripeProcessor.displayPaymentDetails(chargeId);
        
        // Demonstrate same interface for both
        System.out.println("\n─────────────────────────────────────────");
        System.out.println("Both adapters implement same interface!");
        System.out.println("─────────────────────────────────────────");
        processPaymentUnified(new PayPalAdapter(), "ORD-003", 299.0, "CUST-456", "PayPal");
        processPaymentUnified(new StripeAdapter(), "ORD-004", 499.0, "CUST-789", "Stripe");
    }
    
    private static void processPaymentUnified(PaymentProcessor processor, String orderId, 
            double amount, String customerId, String gateway) {
        System.out.println("\n  [Unified] Processing ₹" + amount + " via " + gateway + "...");
        boolean success = processor.processPayment(orderId, amount, customerId);
        System.out.println("  [Unified] Result: " + (success ? "✅ Success" : "❌ Failed"));
    }
    
    // ========== 6. OBSERVER PATTERN ==========
    private static void demonstrateObserver() {
        System.out.println("\n\n============================================================");
        System.out.println("  [6] OBSERVER PATTERN - Order Tracking Updates");
        System.out.println("============================================================");
        
        // Create order tracker
        String orderId = "FD-2024-12345";
        OrderTracker tracker = new OrderTracker(orderId);
        
        // Subscribe observers
        System.out.println("\nSetting up order tracking for Order #" + orderId + "...\n");
        
        tracker.subscribe(new CustomerNotificationObserver("CUST-101", "Rahul", "+91-9876543210"));
        tracker.subscribe(new RestaurantNotificationObserver("REST-001", "Spice Garden"));
        tracker.subscribe(new DeliveryPartnerObserver("DP-501", "Amit Kumar", "KA-01-AB-1234"));
        tracker.subscribe(new AnalyticsObserver());
        
        // Simulate order lifecycle
        System.out.println("\n═══════════════════════════════════════════════");
        System.out.println("  SIMULATING ORDER LIFECYCLE");
        System.out.println("═══════════════════════════════════════════════");
        
        // Step 1: Order placed
        tracker.orderPlaced();
        
        // Step 2: Restaurant confirms
        tracker.orderConfirmed(35);
        
        // Step 3: Preparing
        tracker.preparingOrder();
        
        // Step 4: Ready for pickup
        tracker.readyForPickup();
        
        // Step 5: Out for delivery
        tracker.outForDelivery("Amit Kumar", "Near City Mall", 15);
        
        // Step 6: Delivered
        tracker.delivered();
        
        System.out.println("\n─────────────────────────────────────────");
        System.out.println("Final Order Status: " + tracker.getCurrentStatus());
        System.out.println("─────────────────────────────────────────");
        
        // Demonstrate cancellation flow
        System.out.println("\n\n--- Demonstrating Cancellation Flow ---");
        
        OrderTracker cancelledOrder = new OrderTracker("FD-2024-99999");
        cancelledOrder.subscribe(new CustomerNotificationObserver("CUST-202", "Priya", "+91-8765432100"));
        cancelledOrder.subscribe(new RestaurantNotificationObserver("REST-002", "Pizza Palace"));
        cancelledOrder.subscribe(new AnalyticsObserver());
        
        cancelledOrder.orderPlaced();
        cancelledOrder.orderConfirmed(40);
        cancelledOrder.cancelled("Customer requested cancellation - Changed mind");
        
        System.out.println("\nFinal Order Status: " + cancelledOrder.getCurrentStatus());
    }
}

