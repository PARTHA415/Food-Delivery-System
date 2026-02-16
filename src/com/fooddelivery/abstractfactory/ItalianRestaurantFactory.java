package com.fooddelivery.abstractfactory;

/**
 * Concrete Factory for Italian Restaurant
 */
public class ItalianRestaurantFactory implements RestaurantFactory {
    
    @Override
    public RestaurantUI createUI() {
        return new ItalianRestaurantUI();
    }
    
    @Override
    public MenuProvider createMenuProvider() {
        return new ItalianMenuProvider();
    }
    
    @Override
    public MenuItem createSignatureDish() {
        return new ItalianMenuItem("Margherita Pizza", 
            "Classic pizza with fresh mozzarella, tomatoes, and basil", 
            350.0, "VEG");
    }
}

// Italian UI implementation
class ItalianRestaurantUI implements RestaurantUI {
    @Override
    public String getThemeColor() { return "#E63946"; } // Italian red
    
    @Override
    public String getLogoStyle() { return "Classic Italian Script"; }
    
    @Override
    public String getBannerText() { return "🍝 Authentic Italian Cuisine 🇮🇹"; }
    
    @Override
    public void renderUI() {
        System.out.println("╔══════════════════════════════════════════════╗");
        System.out.println("║     " + getBannerText() + "      ║");
        System.out.println("║  Theme: " + getThemeColor() + " | Style: " + getLogoStyle() + "  ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }
}

// Italian Menu Provider
class ItalianMenuProvider implements MenuProvider {
    @Override
    public String getRestaurantName() { return "La Bella Italia"; }
    
    @Override
    public String getCuisineType() { return "Italian"; }
    
    @Override
    public MenuItem[] getPopularItems() {
        return new MenuItem[] {
            new ItalianMenuItem("Spaghetti Carbonara", "Creamy pasta with bacon and parmesan", 280.0, "NON_VEG"),
            new ItalianMenuItem("Bruschetta", "Toasted bread with tomatoes and basil", 150.0, "VEG"),
            new ItalianMenuItem("Tiramisu", "Classic Italian coffee dessert", 200.0, "VEG")
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

// Italian Menu Item
class ItalianMenuItem implements MenuItem {
    private String name;
    private String description;
    private double price;
    private String type;
    
    public ItalianMenuItem(String name, String description, double price, String type) {
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


