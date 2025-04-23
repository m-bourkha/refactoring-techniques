package com.bourkha.coffemachingkata;

import java.math.BigDecimal;
import java.util.*;

public enum Drink {
    CAFFE_AMERICANO("Caffe Americano", new String[]{"3 Espresso"}),
    CAFFE_LATTE("Caffe Latte", new String[]{"2 Espresso", "1 Steamed Milk"}),
    CAFFE_MOCHA("Caffe Mocha", new String[]{"1 Espresso", "1 Cocoa", "1 Steamed Milk", "1 Whipped Cream"}),
    CAPPUCCINO("Cappuccino", new String[]{"2 Espresso", "1 Steamed Milk", "1 Foamed Milk"}),
    COFFEE("Coffee", new String[]{"3 Coffee", "1 Sugar", "1 Cream"}),
    DECAF_COFFEE("Decaf Coffee", new String[]{"3 Decaf Coffee", "1 Sugar", "1 Cream"});

    Drink(String name, String[] ingredients) {
        this.name = name;
        ingredientsMap = new LinkedHashMap<>();
        cost = BigDecimal.ZERO;
        for (String ingredient : ingredients ) {
            String[] spec = ingredient.split(" ", 2);
            int quantity = Integer.parseInt(spec[0]);
            Ingredient ingredientName = getIngredientName(spec[spec.length - 1]);

            ingredientsMap.put(ingredientName, quantity);
            cost = cost.add(ingredientName.getCost().multiply(BigDecimal.valueOf(quantity)));
        }

    }

    static void assetDringExists(int drinkId) {
        if (drinkId <= 0 || drinkId > values().length) {
            throw new IllegalArgumentException(); //legal, but invalid input
        }
    }

    public String getName() {
        return name;
    }

    private final String name;

    public BigDecimal getCost() {
        return cost;
    }
    private BigDecimal cost;

    private final Map<Ingredient, Integer> ingredientsMap;

    private  Ingredient getIngredientName(String ingredientName) {
        return Arrays.stream(Ingredient.values())
                .filter(ingredientEnum -> ingredientEnum.getName().equals(ingredientName))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public Map<Ingredient, Integer> getIngredientsMap() {
        return Collections.unmodifiableMap(ingredientsMap);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public boolean isMakeable(Map<Ingredient, Integer> stock) {
       return stock.keySet().stream().filter(ingredientsMap::containsKey)
                .allMatch(ingredient -> stock.get(ingredient) >= ingredientsMap.get(ingredient));
    }
}