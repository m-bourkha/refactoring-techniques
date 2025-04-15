import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Drink implements Comparable<Drink> {
    private Map<String, Integer> recipe = new HashMap<String, Integer>();//map ingredients to units per
    private String name;
    private double totalCost = 0;

    public Drink(String name, String[] recipe) {
        this.name = name;
        setRecipe(recipe);
    }

    public int compareTo(Drink drink) {
        return name.compareTo(drink.getName());
    }

    public void setRecipe(String[] recipe) {
        for (String s : recipe) {
            if (this.recipe.containsKey(s)) {
                this.recipe.put(s, this.neededAmount(s) + 1);//increment if multiple units
            } else {
                this.recipe.put(s, 1);//insert first occurrence of ingredient
            }
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public void setMakeable(boolean makeable) {
    }

    public Map<String, Integer> getRecipe() {
        return recipe;
    }

    public double getCost() {
        return totalCost;
    }

    public String getName() {
        return name;
    }

    void makeDrink(View view, List<Ingredient> ingredientList) {
        if (isMakeable(ingredientList)) {
            view.displayDispensing(name);
            for (Ingredient ingredient : ingredientList) {
                if (needed(ingredient)) {
                    ingredient.consume(neededAmount(ingredient.getName()));
                }
            }
        } else {
            view.displayOutOfStack(this.getName());
        }
    }

    public boolean isMakeable(List<Ingredient> ingredientList) {
        return ingredientList.stream()
                .filter(this::needed)
                .allMatch(this::isAvailable);
    }

    private boolean isAvailable(Ingredient ingredient) {
        return ingredient.available(neededAmount(ingredient.getName()));
    }

    private Integer neededAmount(String ingredientName) {
        return recipe.get(ingredientName);
    }

    private boolean needed(Ingredient ingredient) {
        return recipe.containsKey(ingredient.getName());
    }
}