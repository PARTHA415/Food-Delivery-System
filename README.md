# Food Delivery System - Design Patterns Implementation

A comprehensive Java project demonstrating 6 different design patterns using an online food delivery system as the example domain.

## Project Overview

**Food Delivery System** is an educational project that showcases industry-standard design patterns applied to a real-world food delivery platform similar to Swiggy/Zomato/UberEats. The project demonstrates how each pattern solves specific design problems.

## Design Patterns Implemented

| Pattern | Use Case | Package |
|---------|----------|---------|
| **Abstract Factory** | Restaurant UI / Menu providers | `com.fooddelivery.abstractfactory` |
| **Composite** | Menu → Category → Items hierarchy | `com.fooddelivery.composite` |
| **Strategy** | Delivery fee calculation | `com.fooddelivery.strategy` |
| **Decorator** | Add-ons (extra cheese, toppings) | `com.fooddelivery.decorator` |
| **Adapter** | Third-party payment gateways | `com.fooddelivery.adapter` |
| **Observer** | Order tracking updates | `com.fooddelivery.observer` |

## Project Structure

```
FoodDeliverySystem/
├── src/
│   └── com/
│       └── fooddelivery/
│           ├── Main.java                    # Main demonstration class
│           │
│           ├── abstractfactory/             # Abstract Factory Pattern
│           │   ├── RestaurantFactory.java   # Abstract factory interface
│           │   ├── MenuItem.java            # Abstract product
│           │   ├── RestaurantUI.java        # Abstract product
│           │   ├── MenuProvider.java        # Abstract product
│           │   ├── ItalianRestaurantFactory.java
│           │   ├── IndianRestaurantFactory.java
│           │   └── ChineseRestaurantFactory.java
│           │
│           ├── composite/                   # Composite Pattern
│           │   ├── MenuComponent.java       # Component interface
│           │   ├── FoodItem.java            # Leaf
│           │   ├── MenuCategory.java        # Composite
│           │   └── Menu.java                # Root composite
│           │
│           ├── strategy/                    # Strategy Pattern
│           │   ├── DeliveryFeeStrategy.java # Strategy interface
│           │   ├── StandardDeliveryStrategy.java
│           │   ├── ExpressDeliveryStrategy.java
│           │   ├── NightDeliveryStrategy.java
│           │   ├── FreeDeliveryStrategy.java
│           │   └── DeliveryFeeCalculator.java
│           │
│           ├── decorator/                   # Decorator Pattern
│           │   ├── Food.java                # Component interface
│           │   ├── Pizza.java               # Concrete component
│           │   ├── Burger.java              # Concrete component
│           │   ├── FoodDecorator.java       # Abstract decorator
│           │   ├── ExtraCheeseDecorator.java
│           │   ├── ToppingDecorator.java
│           │   └── SauceDecorator.java
│           │
│           ├── adapter/                     # Adapter Pattern
│           │   ├── PaymentProcessor.java    # Target interface
│           │   ├── PayPalAPI.java           # Adaptee
│           │   ├── StripeAPI.java           # Adaptee
│           │   ├── PayPalAdapter.java       # Adapter
│           │   └── StripeAdapter.java       # Adapter
│           │
│           └── observer/                    # Observer Pattern
│               ├── OrderObserver.java       # Observer interface
│               ├── OrderEvent.java          # Event object
│               ├── OrderTracker.java        # Subject/Publisher
│               ├── CustomerNotificationObserver.java
│               ├── RestaurantNotificationObserver.java
│               ├── DeliveryPartnerObserver.java
│               └── AnalyticsObserver.java
│
├── bin/                                     # Compiled classes
├── build.gradle                             # Gradle build file
├── settings.gradle                          # Gradle settings
├── run.bat                                  # Windows run script
├── run.sh                                   # Linux/Mac run script
└── README.md                                # This file
```

## Pattern Details

### 1. Abstract Factory Pattern - Restaurant UI/Menu Providers
Creates families of related objects (UI, Menu, Signature Dish) for different restaurant types:
- **ItalianRestaurantFactory**: Italian theme, pasta menu, Margherita signature
- **IndianRestaurantFactory**: Indian theme, curry menu, Butter Chicken signature
- **ChineseRestaurantFactory**: Chinese theme, dim sum menu, Kung Pao signature

### 2. Composite Pattern - Menu Structure
Hierarchical menu structure with uniform interface:
```
Menu (Restaurant)
├── Appetizers (Category)
│   ├── Spring Rolls (Item)
│   └── Chicken Wings (Item)
├── Main Course (Category)
│   ├── Vegetarian (Sub-Category)
│   │   ├── Paneer Masala (Item)
│   │   └── Veg Biryani (Item)
│   └── Non-Vegetarian (Sub-Category)
│       ├── Butter Chicken (Item)
│       └── Lamb Rogan Josh (Item)
└── Desserts (Category)
```

### 3. Strategy Pattern - Delivery Fee Calculation
Different pricing strategies for delivery:
- **StandardDeliveryStrategy**: Base ₹30 + ₹5/km
- **ExpressDeliveryStrategy**: 1.5x surge with premium base
- **NightDeliveryStrategy**: Night surcharge + per km
- **FreeDeliveryStrategy**: Free above ₹500 threshold

### 4. Decorator Pattern - Food Add-ons
Dynamically add features to food items:
- **ExtraCheeseDecorator**: +₹40
- **ToppingDecorator**: Mushrooms, Olives, Jalapenos, Pepperoni
- **SauceDecorator**: BBQ, Garlic Mayo, Hot Sauce, Pesto

Example: `Pizza + Extra Cheese + Mushrooms + Jalapenos = ₹350`

### 5. Adapter Pattern - Payment Gateways
Adapts third-party payment APIs to common interface:
- **PayPalAdapter**: Converts INR to USD, adapts PayPal's API
- **StripeAdapter**: Converts to paise, adapts Stripe's Charge API

Both work through unified `PaymentProcessor` interface.

### 6. Observer Pattern - Order Tracking
Real-time notifications to all stakeholders:
- **CustomerNotificationObserver**: SMS/Push to customer
- **RestaurantNotificationObserver**: Updates to restaurant
- **DeliveryPartnerObserver**: Instructions to delivery person
- **AnalyticsObserver**: Logs all events

Order lifecycle: `PLACED → CONFIRMED → PREPARING → READY → OUT_FOR_DELIVERY → DELIVERED`

## How to Run

### Using IntelliJ IDEA (Recommended)
1. Open IntelliJ IDEA
2. File → Open → Select `FoodDeliverySystem` folder
3. Choose "Open as Project" when prompted for `build.gradle`
4. Wait for Gradle sync
5. Navigate to `src/com/fooddelivery/Main.java`
6. Right-click → Run 'Main.main()'

### Using Command Line

**Windows:**
```cmd
cd FoodDeliverySystem
run.bat
```

Or manually:
```cmd
cd src
javac -encoding UTF-8 -d ..\bin com\fooddelivery\*.java com\fooddelivery\abstractfactory\*.java com\fooddelivery\composite\*.java com\fooddelivery\strategy\*.java com\fooddelivery\decorator\*.java com\fooddelivery\adapter\*.java com\fooddelivery\observer\*.java
cd ..
java -cp bin com.fooddelivery.Main
```

**Linux/Mac:**
```bash
cd FoodDeliverySystem
chmod +x run.sh
./run.sh
```

### Using Gradle
```bash
./gradlew run
```

## Sample Output

```
============================================================
         FOOD DELIVERY SYSTEM - DEMO
============================================================

[1] ABSTRACT FACTORY PATTERN
  🇮🇹 Italian Restaurant UI & Menu
  🇮🇳 Indian Restaurant UI & Menu
  🇨🇳 Chinese Restaurant UI & Menu

[2] COMPOSITE PATTERN
  📁 Full menu hierarchy with 15 items
  Categories: Appetizers, Main Course, Desserts, Beverages

[3] STRATEGY PATTERN
  Standard: ₹55.00
  Express: ₹127.50
  Night: ₹115.00
  Free (above ₹500): ₹0.00

[4] DECORATOR PATTERN
  Pizza + Cheese + Mushrooms + Jalapenos + BBQ = ₹365.00
  Burger + Cheese + Onions + Mayo = ₹235.00

[5] ADAPTER PATTERN
  ✅ PayPal payment processed (converted to USD)
  ✅ Stripe payment processed (in paise)

[6] OBSERVER PATTERN
  📱 Customer notified
  🏪 Restaurant notified
  🛵 Delivery partner notified
  📊 Analytics logged
```

## Learning Outcomes

- Understand when and how to apply each design pattern
- See real-world applications in a food delivery context
- Learn best practices for maintainable, extensible code
- Master the SOLID principles through practical examples
- Understand how to integrate third-party services using Adapter pattern
- Learn event-driven architecture with Observer pattern

