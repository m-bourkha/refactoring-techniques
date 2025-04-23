package com.bourkha.coffemachingkata;

public class View {
    void invalidSelection(String input) {
        System.out.println("Invalid selection: " + input + ". Try again: ");
    }

    public void display(CoffeeMachine coffeeMachine) {
        System.out.println("Inventory:");
        for (Ingredient ingredient : coffeeMachine.getStock().keySet()) {
            System.out.println(ingredient.getName() + "," + coffeeMachine.getStock().get(ingredient));
        }

        System.out.println("\nMenu:");
        int count = 1;
        for (Drink drink : Drink.values()) {
            System.out.printf("%d,%s,$%.2f," + drink.isMakeable(coffeeMachine.getStock()) + "\n", count, drink.getName(), drink.getCost());
            count++;
        }

        System.out.print("\nYour selection: ");
    }

    void outOfStock(Drink drink) {
        System.out.println("Out of stock: " + drink.getName() + "\n");
    }

    void servingDrink(Drink drink) {
        System.out.println("Dispensing: " + drink.getName() + "\n");
    }
}