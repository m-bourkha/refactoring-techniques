package com.bourkha.coffemachinekata;

public class View {

    public void askForSelection(CoffeeMachine coffeeMachine) {
        showMessage("com.bourkha.coffemachinekata.Inventory:");
        for (Stock stock : coffeeMachine.inventory) {
            showMessage(stock.getName() + "," + stock.getAmount());
        }

        showMessage("\nMenu:");
        int count = 1;
        for (Drink drink : coffeeMachine.getMenu()) {
            System.out.printf("%d,%s,$%.2f," + coffeeMachine.canMake(drink) + "\n", count, drink.getName(), coffeeMachine.cost(drink));
            count++;
        }

        System.out.print("\nYour selection: ");
    }

    public void showMessage(String name) {
        System.out.println(name);
    }

}