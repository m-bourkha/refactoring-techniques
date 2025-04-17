import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.function.Function.*;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public class Drink implements Comparable<Drink> {
    public Map<String, Integer> recipe;
    private String name;

    public Drink(String name, String[] recipe) {
        this.name = name;
        this.recipe = Arrays.stream(recipe).collect(groupingBy(identity(), summingInt(s -> 1)));

    }

    public String getName() {
        return name;
    }

    public Integer neededAmount(String name) {
        return this.recipe.getOrDefault(name,0);
    }

    public int compareTo(Drink drink) {
        return name.compareTo(drink.getName());
    }

}