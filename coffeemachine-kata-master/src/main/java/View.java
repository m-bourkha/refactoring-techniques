import java.util.List;

public class View {
    void dispalayInvalid(String input) {
        System.out.print("Invalid selection: " + input + ". Try again: "); //illegal input
    }

    public void askForSelection(List<Ingredient> ingredientList, List<Drink> drinkList) {
        System.out.println("Inventory:");
        for (Ingredient i : ingredientList) {
            System.out.println(i.getName() + "," + i.getStock());
        }

        System.out.println("\nMenu:");
        int count = 1;
        for (Drink drink : drinkList) {
            System.out.printf("%d,%s,$%.2f," + drink.isMakeable(ingredientList) + "\n", count, drink.getName(), drink.getCost());
            count++;
        }

        System.out.print("\nYour selection: ");
    }

    void displayOutOfStack(String name) {
        System.out.println("Out of stock: " + name + "\n");
    }

    void displayDispensing(String name) {
        System.out.println("Dispensing: " + name + "\n");
    }
}