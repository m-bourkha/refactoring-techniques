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
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            return true;
        }
    };

    abstract boolean exectute(String command, CoffeeMachine coffeeMachine, View view);

     void restock(CoffeeMachine coffeeMachine) {
        coffeeMachine.restock();
    }

     void make(String command, CoffeeMachine coffeeMachine, View view) throws IllegalAccessException {
        Drink drink = coffeeMachine.findDrinkById(Integer.parseInt(command));
        coffeeMachine.make(drink,
                () -> view.showMessage("Out of stock: " + drink.getName() + "\n"),
                () -> view.showMessage("Dispensing: " + drink.getName() + "\n"));
    }

    public static COMMAND from(String command) {
        return switch (command) {
            case "" -> EMPTY;
            case "q" -> QUIT;
            case "r" -> RESTOCK;
            default -> DEFAULT;
        };
    }
}
