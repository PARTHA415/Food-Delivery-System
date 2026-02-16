package com.fooddelivery.abstractfactory;

/**
 * Abstract product for menu provider
 */
public interface MenuProvider {
    String getRestaurantName();
    String getCuisineType();
    MenuItem[] getPopularItems();
    void displayMenu();
}

