package com.fooddelivery.abstractfactory;

/**
 * Abstract product for restaurant UI theme
 */
public interface RestaurantUI {
    String getThemeColor();
    String getLogoStyle();
    String getBannerText();
    void renderUI();
}

