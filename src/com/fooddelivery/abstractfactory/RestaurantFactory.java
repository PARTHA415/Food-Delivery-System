package com.fooddelivery.abstractfactory;

/**
 * Abstract Factory interface for creating restaurant-related products
 */
public interface RestaurantFactory {
    RestaurantUI createUI();
    MenuProvider createMenuProvider();
    MenuItem createSignatureDish();
}

