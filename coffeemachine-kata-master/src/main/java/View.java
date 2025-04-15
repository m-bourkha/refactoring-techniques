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
        for (Drink d : drinkList) {
            System.out.printf("%d,%s,$%.2f," + d.getMakeable() + "\n", count, d.getName(), d.getCost());
            count++;
        }

        System.out.print("\nYour selection: ");
    }

    void displayOutOfStack(Drink drink) {
        System.out.println("Out of stock: " + drink.getName() + "\n");
    }

    void displayDispensing(Drink drink) {
        System.out.println("Dispensing: " + drink.getName() + "\n");
    }
}