import java.util.ArrayList;

public class CoffeeMachineApp {

    public static final String EMPTY = "";
    public static final String QUIT = "q";
    public static final String RESTOCK = "r";

    public static void main(String[] args) {

        control(new View(), new CoffeeMachine(new ArrayList<>()), new Input(null));
    }

    public static void control(View view, CoffeeMachine coffeeMachine, Input input) {
        String command = EMPTY;
        view.askForSelection(coffeeMachine);
        while (true) {
            try {
                command = input.get();
                boolean result = COMMAND.from(command).exectute(command, coffeeMachine, view);
                if(!result) return;
                view.askForSelection(coffeeMachine);
            } catch (Exception e) {
                view.showMessage("Invalid selection: " + command + ". Try again: "); //illegal input
            }
        }
    }

}
