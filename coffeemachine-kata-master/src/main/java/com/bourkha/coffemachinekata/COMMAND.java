package com.bourkha.coffemachinekata;

public enum COMMAND {
    EMPTY {
        @Override
        boolean exectute(String command, CoffeeMachine coffeeMachine, View view) {
            return true;
        }
    },
    QUIT {
        @Override
        boolean exectute(String command, CoffeeMachine coffeeMachine, View view) {
            return false;
        }
    },
    RESTOCK{
        @Override
        boolean exectute(String command, CoffeeMachine coffeeMachine, View view) {
            restock(coffeeMachine);
            return true;
        }
    },
    DEFAULT {
        @Override
        boolean exectute(String command, CoffeeMachine coffeeMachine, View view) {
            try {
                make(command, coffeeMachine, view);
            } catch (IllegalArgumentException e) {
                throw  e;
            }
            return true;
        }
    };

    abstract boolean exectute(String command, CoffeeMachine coffeeMachine, View view);

     void restock(CoffeeMachine coffeeMachine) {
        coffeeMachine.restock();
    }

     void make(String command, CoffeeMachine coffeeMachine, View view) {
        Drink drink = coffeeMachine.findDrinkById(Integer.parseInt(command));
        coffeeMachine.make(drink,
                () -> view.showMessage("Out of stock: " + drink.getName() + "\n"),
                () -> view.showMessage("Dispensing: " + drink.getName() + "\n"));
    }


}
