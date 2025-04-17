import java.util.Collections;
import java.util.List;

public class CoffeeMachine {
    public final Inventory inventory = new Inventory();
    private List<Drink> menu;

    public CoffeeMachine(List<Drink> menu) {
        this.menu = menu;

        menu.add(new Drink("Coffee", new String[]{"Coffee", "Coffee", "Coffee", "Sugar", "Cream"}));
        menu.add(new Drink("Decaf Coffee", new String[]{"Decaf Coffee", "Decaf Coffee", "Decaf Coffee", "Sugar", "Cream"}));
        menu.add(new Drink("Caffe Latte", new String[]{"Espresso", "Espresso", "Steamed Milk"}));
        menu.add(new Drink("Caffe Americano", new String[]{"Espresso", "Espresso", "Espresso"}));
        menu.add(new Drink("Caffe Mocha", new String[]{"Espresso", "Cocoa", "Steamed Milk", "Whipped Cream"}));
        menu.add(new Drink("Cappuccino", new String[]{"Espresso", "Espresso", "Steamed Milk", "Foamed Milk"}));

        Collections.sort(this.getMenu());
    }

    public void restock() {
        inventory.recstock();
    }

    void make(Drink drink, Runnable OnError, Runnable OnSuccess) {
        inventory.make(drink, OnError, OnSuccess);

    }

    public boolean canMake(Drink drink) {
        return inventory.canMake(drink) ;
    }

    public Drink findDrinkById(int dringId) throws IllegalAccessException {
        assertDrinkExists(dringId);

        //dynamic drink menu selection
        return menu.get(dringId - 1);
    }

    private void assertDrinkExists(int dringId) throws IllegalAccessException {
        if (dringId <= 0 || dringId > menu.size()) {
            throw new IllegalAccessException(); //legal, but invalid input
        }
    }

    public List<Drink> getMenu() {
        return menu;
    }

    public double cost(Drink drink) {
        return inventory.cost(drink);
    }
}