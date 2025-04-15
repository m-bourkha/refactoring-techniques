import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CoffeeMachine {

    public static void main(String[] args) {
        Model model = new Model(new ArrayList<Drink>(), new ArrayList<Ingredient>());
        // View
        View view = new View();
        view.askForSelection(model.getIngredientList(), model.getDrinkList());

       // Controller
        control(view, model);
    }

    public static void control(View view, Model model) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";

        while (true) {
            try {
                input = reader.readLine().toLowerCase();

                if (input.equals("")) {
                    continue;
                } else if (input.equals("q")) {
                    break;
                } else if (input.equals("r")) {
                    model.restockIngredients();
                } else {
                    model.makeDrink(view, Integer.parseInt(input));
                }
                view.askForSelection(model.getIngredientList(), model.getDrinkList());
            } catch (Exception e) {
                view.dispalayInvalid(input);
            }
        }
    }

}
