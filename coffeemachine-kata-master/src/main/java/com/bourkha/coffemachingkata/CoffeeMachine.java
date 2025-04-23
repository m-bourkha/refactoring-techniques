package com.bourkha.coffemachingkata;

import java.util.*;

public class CoffeeMachine {
    public CoffeeMachine() {
        stock = new LinkedHashMap<>();
        restockIngredients();
    }

    private  final Map<Ingredient, Integer> stock;

    void make(String input, View view) {
        int command = Integer.parseInt(input);
        makeDrink(command,
                () -> view.servingDrink(Drink.values()[command - 1]),
                () -> view.outOfStock(Drink.values()[command -1]));
    }

    void makeDrink(int drinkId, Runnable onSuccess, Runnable onFailure) {
        Drink.assetDringExists(drinkId);
        makeDrink(Drink.values()[drinkId - 1],
                onSuccess,
               onFailure);
    }

    public void makeDrink(Drink drink, Runnable onSuccess, Runnable onFailure) {
        if (drink.isMakeable(stock)) {
            onSuccess.run();
            Map<Ingredient, Integer> ingredientQuantity = drink.getIngredientsMap();

            for (Ingredient ingredient : ingredientQuantity.keySet()) {
                stock.compute(ingredient, (ingredient1, amount) -> consume(ingredient, amount, ingredientQuantity));
            }
        } else {
            onFailure.run();
        }
    }

    private static int consume(Ingredient ingredient, Integer amount, Map<Ingredient, Integer> ingredientQuantity) {
        return ingredientQuantity.get(ingredient) <= amount ? amount - ingredientQuantity.get(ingredient) : amount;
    }

    public void restockIngredients() {
        for (Ingredient ingredient : Ingredient.values()) {
            stock.put(ingredient, 10);
        }
    }

    public Map<Ingredient, Integer> getStock() {
        return Collections.unmodifiableMap(stock);
    }
}