package com.fooddelivery.abstractfactory;

/**
 * Abstract product for menu items
 */
public interface MenuItem {
    String getName();
    String getDescription();
    double getPrice();
    String getType(); // VEG, NON_VEG, VEGAN
    void display();
}

