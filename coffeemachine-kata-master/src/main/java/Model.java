import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Model {
    private List<Drink> drinkList;
    private List<Ingredient> ingredientList;

    public Model(List<Drink> drinkList, List<Ingredient> ingredientList) {
        this.setDrinkList(drinkList);
        this.setIngredientList(ingredientList);
        addAllIngredients();
        addAllDrinks();
        updateCosts();
        updateMakeable();
    }

    public void restockIngredients() {
        for (Ingredient i : getIngredientList()) {
            i.setStock(10);
        }
        updateMakeable();
    }

    public void updateMakeable() {
        for (Drink d : getDrinkList()) {
            Map<String, Integer> currRecipe = d.getRecipe();
            for (Ingredient i : getIngredientList()) {
                if (currRecipe.containsKey(i.getName()) && i.getStock() < currRecipe.get(i.getName())) {
                    d.setMakeable(false);
                    break;
                }
                d.setMakeable(true);
            }
        }
    }

    public void updateCosts() {
        for (Drink d : getDrinkList()) {
            double currCost = 0;
            Map<String, Integer> currRecipe = d.getRecipe();
            for (Ingredient i : getIngredientList()) {
                if (currRecipe.containsKey(i.getName())) {
                    currCost += i.getCost() * currRecipe.get(i.getName());
                }
            }
            d.setCost(currCost);
        }
    }

    public void addIngredient(Ingredient ingredient) {
        getIngredientList().add(ingredient);
    }

    public void addDrink(String name, String[] recipe) {
        getDrinkList().add(new Drink(name, recipe));
    }

    public void addAllIngredients() {
        addIngredient(new Ingredient("Coffee", 0.75));
        addIngredient(new Ingredient("Decaf Coffee", 0.75));
        addIngredient(new Ingredient("Sugar", 0.25));
        addIngredient(new Ingredient("Cream", 0.25));
        addIngredient(new Ingredient("Steamed Milk", 0.35));
        addIngredient(new Ingredient("Foamed Milk", 0.35));
        addIngredient(new Ingredient("Espresso", 1.10));
        addIngredient(new Ingredient("Cocoa", 0.90));
        addIngredient(new Ingredient("Whipped Cream", 1.00));

        Collections.sort(getIngredientList());
    }

    public void addAllDrinks() {
        addDrink("Coffee", new String[]{"Coffee", "Coffee", "Coffee", "Sugar", "Cream"});
        addDrink("Decaf Coffee", new String[]{"Decaf Coffee", "Decaf Coffee", "Decaf Coffee", "Sugar", "Cream"});
        addDrink("Caffe Latte", new String[]{"Espresso", "Espresso", "Steamed Milk"});
        addDrink("Caffe Americano", new String[]{"Espresso", "Espresso", "Espresso"});
        addDrink("Caffe Mocha", new String[]{"Espresso", "Cocoa", "Steamed Milk", "Whipped Cream"});
        addDrink("Cappuccino", new String[]{"Espresso", "Espresso", "Steamed Milk", "Foamed Milk"});

        Collections.sort(getDrinkList());
    }

    void makeDrink(View view, int dringId) throws IllegalAccessException {
        if (dringId <= 0 || dringId > getDrinkList().size()) {
            throw new IllegalAccessException(); //legal, but invalid input
        } //dynamic drink menu selection

        Drink drink = getDrinkList().get(dringId - 1);
        if (drink.getMakeable()) {
            view.displayDispensing(drink);
            for (Ingredient i : getIngredientList()) {
                if (drink.getRecipe().containsKey(i.getName())) {
                    i.setStock(i.getStock() - drink.getRecipe().get(i.getName()));
                }
            }
        } else {
            view.displayOutOfStack(drink);
        }
        updateMakeable();

    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public List<Drink> getDrinkList() {
        return drinkList;
    }

    public void setDrinkList(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }
}