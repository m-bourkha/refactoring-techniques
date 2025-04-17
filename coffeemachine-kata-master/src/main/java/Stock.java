public class Stock implements Comparable<Stock> {
    private String name = "";
    private double cost = 0.00;
    private int amount = 0;

    public Stock(String name, double cost) {
        this.name = name;
        this.cost = cost;
        this.amount = 10;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    void restock() {
        this.amount = 10;
    }

    boolean available(Drink drink) {
        return amount >= drink.neededAmount(getName());
    }

    void consume(Drink drink) {
        this.amount = amount - drink.neededAmount(name);
    }

    double cost(Drink drink) {
        return cost * drink.neededAmount(name);
    }

    public int compareTo(Stock stock) {
        return name.compareTo(stock.getName());
    }

}