package com.fooddelivery.abstractfactory;

/**
 * Concrete Factory for Indian Restaurant
 */
public class IndianRestaurantFactory implements RestaurantFactory {
    
    @Override
    public RestaurantUI createUI() {
        return new IndianRestaurantUI();
    }
    
    @Override
    public MenuProvider createMenuProvider() {
        return new IndianMenuProvider();
    }
    
    @Override
    public MenuItem createSignatureDish() {
        return new IndianMenuItem("Butter Chicken", 
            "Creamy tomato-based curry with tender chicken pieces", 
            320.0, "NON_VEG");
    }
}

// Indian UI implementation
class IndianRestaurantUI implements RestaurantUI {
    @Override
    public String getThemeColor() { return "#FF9933"; } // Saffron orange
    
    @Override
    public String getLogoStyle() { return "Traditional Devanagari"; }
    
    @Override
    public String getBannerText() { return "🍛 Authentic Indian Flavors 🇮🇳"; }
    
    @Override
    public void renderUI() {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║    " + getBannerText() + "     ║");
        System.out.println("║  Theme: " + getThemeColor() + " | Style: " + getLogoStyle() + " ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }
}

// Indian Menu Provider
class IndianMenuProvider implements MenuProvider {
    @Override
    public String getRestaurantName() { return "Spice Garden"; }
    
    @Override
    public String getCuisineType() { return "Indian"; }
    
    @Override
    public MenuItem[] getPopularItems() {
        return new MenuItem[] {
            new IndianMenuItem("Paneer Tikka", "Grilled cottage cheese with spices", 250.0, "VEG"),
            new IndianMenuItem("Biryani", "Fragrant basmati rice with spices and meat", 300.0, "NON_VEG"),
            new IndianMenuItem("Dal Makhani", "Creamy black lentils cooked overnight", 180.0, "VEG"),
            new IndianMenuItem("Gulab Jamun", "Sweet milk dumplings in sugar syrup", 120.0, "VEG")
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

// Indian Menu Item
class IndianMenuItem implements MenuItem {
    private String name;
    private String description;
    private double price;
    private String type;
    
    public IndianMenuItem(String name, String description, double price, String type) {
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


