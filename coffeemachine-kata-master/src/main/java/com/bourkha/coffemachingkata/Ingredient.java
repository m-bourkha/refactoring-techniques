package com.bourkha.coffemachingkata;

import java.math.BigDecimal;

public enum Ingredient {
    COCOA("Cocoa", 0.90),
    COFFEE("Coffee", 0.75),
    CREAM("Cream", 0.25),
    DECAF_COFFEE("Decaf Coffee", 0.75),
    ESPRESSO("Espresso", 1.10),
    FOAMED_MILK("Foamed Milk", 0.35),
    STEAMED_MILK("Steamed Milk", 0.35),
    SUGAR("Sugar", 0.25),
    WHIPPED_CREAM("Whipped Cream", 1.00);


    private final String name;
    private final BigDecimal cost;

    Ingredient(String name, double cost) {
        this.name = name;
        this.cost = BigDecimal.valueOf(cost);
    }



    public String getName() {
        return name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
