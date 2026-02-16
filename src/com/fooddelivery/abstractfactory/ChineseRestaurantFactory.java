package com.fooddelivery.abstractfactory;

/**
 * Concrete Factory for Chinese Restaurant
 */
public class ChineseRestaurantFactory implements RestaurantFactory {
    
    @Override
    public RestaurantUI createUI() {
        return new ChineseRestaurantUI();
    }
    
    @Override
    public MenuProvider createMenuProvider() {
        return new ChineseMenuProvider();
    }
    
    @Override
    public MenuItem createSignatureDish() {
        return new ChineseMenuItem("Kung Pao Chicken", 
            "Spicy stir-fried chicken with peanuts and vegetables", 
            290.0, "NON_VEG");
    }
}

// Chinese UI implementation
class ChineseRestaurantUI implements RestaurantUI {
    @Override
    public String getThemeColor() { return "#DE2910"; } // Chinese red
    
    @Override
    public String getLogoStyle() { return "Traditional Chinese Calligraphy"; }
    
    @Override
    public String getBannerText() { return "🥢 Authentic Chinese Cuisine 🇨🇳"; }
    
    @Override
    public void renderUI() {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║   " + getBannerText() + "    ║");
        System.out.println("║  Theme: " + getThemeColor() + " | Style: Chinese Calligraphy ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }
}

// Chinese Menu Provider
class ChineseMenuProvider implements MenuProvider {
    @Override
    public String getRestaurantName() { return "Golden Dragon"; }
    
    @Override
    public String getCuisineType() { return "Chinese"; }
    
    @Override
    public MenuItem[] getPopularItems() {
        return new MenuItem[] {
            new ChineseMenuItem("Dim Sum Platter", "Assorted steamed dumplings", 350.0, "NON_VEG"),
            new ChineseMenuItem("Vegetable Manchurian", "Crispy veggie balls in spicy sauce", 220.0, "VEG"),
            new ChineseMenuItem("Fried Rice", "Wok-tossed rice with vegetables", 180.0, "VEG"),
            new ChineseMenuItem("Spring Rolls", "Crispy rolls with vegetable filling", 150.0, "VEG")
        };
    }
    
    @Override
    public void displayMenu() {
        System.out.println("\n📋 " + getRestaurantName() + " - " + getCuisineType() + " Menu");
        System.out.println("─────────────────────────────────────────────");
        for (MenuItem item : getPopularItems()) {
            item.display();
        }
    }
}

// Chinese Menu Item
class ChineseMenuItem implements MenuItem {
    private String name;
    private String description;
    private double price;
    private String type;
    
    public ChineseMenuItem(String name, String description, double price, String type) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
    }
    
    @Override
    public String getName() { return name; }
    
    @Override
    public String getDescription() { return description; }
    
    @Override
    public double getPrice() { return price; }
    
    @Override
    public String getType() { return type; }
    
    @Override
    public void display() {
        String typeIcon = type.equals("VEG") ? "🟢" : "🔴";
        System.out.println("  " + typeIcon + " " + name + " - ₹" + price);
        System.out.println("      " + description);
    }
}


