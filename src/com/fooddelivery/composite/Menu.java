package com.fooddelivery.composite;

/**
 * Root composite - represents the entire restaurant menu
 */
public class Menu implements MenuComponent {
    private String restaurantName;
    private MenuCategory root;
    
    public Menu(String restaurantName) {
        this.restaurantName = restaurantName;
        this.root = new MenuCategory("Main Menu", "Complete menu of " + restaurantName);
    }
    
    @Override
    public String getName() {
        return restaurantName + " Menu";
    }
    
    @Override
    public String getDescription() {
        return "Complete menu for " + restaurantName;
    }
    
    @Override
    public double getPrice() {
        return root.getPrice();
    }
    
    @Override
    public void add(MenuComponent component) {
        root.add(component);
    }
    
    @Override
    public void remove(MenuComponent component) {
        root.remove(component);
    }
    
    @Override
    public MenuComponent getChild(int index) {
        return root.getChild(index);
    }
    
    @Override
    public int getItemCount() {
        return root.getItemCount();
    }
    
    @Override
    public void display(int indent) {
        System.out.println("\n══════════════════════════════════════════════════");
        System.out.println("  🍽️  " + restaurantName.toUpperCase() + " - FULL MENU");
        System.out.println("  📊 Total Items: " + getItemCount());
        System.out.println("══════════════════════════════════════════════════");
        
        for (MenuComponent component : root.getComponents()) {
            component.display(indent);
        }
        
        System.out.println("\n══════════════════════════════════════════════════");
    }
    
    public String getRestaurantName() {
        return restaurantName;
    }
}


