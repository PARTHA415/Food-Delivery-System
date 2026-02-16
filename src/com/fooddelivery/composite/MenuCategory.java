package com.fooddelivery.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite class - represents a category containing menu items or sub-categories
 */
public class MenuCategory implements MenuComponent {
    private String name;
    private String description;
    private List<MenuComponent> components;
    
    public MenuCategory(String name, String description) {
        this.name = name;
        this.description = description;
        this.components = new ArrayList<>();
    }
    
    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public String getDescription() {
        return description;
    }
    
    @Override
    public double getPrice() {
        // Returns total price of all items in category
        double total = 0;
        for (MenuComponent component : components) {
            total += component.getPrice();
        }
        return total;
    }
    
    @Override
    public void add(MenuComponent component) {
        components.add(component);
    }
    
    @Override
    public void remove(MenuComponent component) {
        components.remove(component);
    }
    
    @Override
    public MenuComponent getChild(int index) {
        return components.get(index);
    }
    
    @Override
    public int getItemCount() {
        int count = 0;
        for (MenuComponent component : components) {
            count += component.getItemCount();
        }
        return count;
    }
    
    @Override
    public void display(int indent) {
        String indentation = repeatString("  ", indent);
        
        System.out.println();
        System.out.println(indentation + "📁 " + name.toUpperCase());
        System.out.println(indentation + "   " + description);
        System.out.println(indentation + "   " + "───────────────────────────────────");
        
        for (MenuComponent component : components) {
            component.display(indent + 1);
        }
    }
    
    private String repeatString(String str, int times) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
    
    public List<MenuComponent> getComponents() {
        return new ArrayList<>(components);
    }
    
    @Override
    public String toString() {
        return name + " (" + getItemCount() + " items)";
    }
}


