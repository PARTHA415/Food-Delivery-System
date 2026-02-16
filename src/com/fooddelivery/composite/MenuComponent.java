package com.fooddelivery.composite;

/**
 * Component interface for the Composite Pattern
 * Represents both individual items and categories in the menu
 */
public interface MenuComponent {
    String getName();
    String getDescription();
    double getPrice();
    void display(int indent);
    
    // Default implementations for composite operations
    default void add(MenuComponent component) {
        throw new UnsupportedOperationException("Cannot add to this component");
    }
    
    default void remove(MenuComponent component) {
        throw new UnsupportedOperationException("Cannot remove from this component");
    }
    
    default MenuComponent getChild(int index) {
        throw new UnsupportedOperationException("Cannot get child from this component");
    }
    
    default int getItemCount() {
        return 1;
    }
    
    default boolean isVegetarian() {
        return false;
    }
}

