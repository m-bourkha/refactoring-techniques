package com.bourkha.coffemachingkata;

public enum COMAND {
    EMPTY {
        @Override
        boolean execute(String command, CoffeeMachine coffeeMachine, View view) {
            return true;
        }
    },
    QUIT {
        @Override
        boolean execute(String command, CoffeeMachine coffeeMachine, View view) {
            return false;
        }
    },
    RESTOCK {
        @Override
        boolean execute(String command, CoffeeMachine coffeeMachine, View view) {
            restock(coffeeMachine);
            return true;
        }
    },
    DEFAULT {
        @Override
        boolean execute(String command, CoffeeMachine coffeeMachine, View view) {
            make(command,coffeeMachine, view);
            return true;
        }
    };

    static void restock(CoffeeMachine coffeeMachine) {
        coffeeMachine.restockIngredients();
    }

    static void make(String input, CoffeeMachine coffeeMachine, View view) {
        coffeeMachine.make(input, view);
    }

    abstract boolean execute(String command, CoffeeMachine coffeeMachine, View view);
}
