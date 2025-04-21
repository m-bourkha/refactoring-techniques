package com.bourkha.coffemachinekata;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Inventory implements Iterable<Stock>{
    public List<Stock> stockList;

    public Inventory() {
        stockList = new ArrayList<>();
        stockList.add(new Stock("Coffee", 0.75));
        stockList.add(new Stock("Decaf Coffee", 0.75));
        stockList.add(new Stock("Sugar", 0.25));
        stockList.add(new Stock("Cream", 0.25));
        stockList.add(new Stock("Steamed Milk", 0.35));
        stockList.add(new Stock("Foamed Milk", 0.35));
        stockList.add(new Stock("Espresso", 1.10));
        stockList.add(new Stock("Cocoa", 0.90));
        stockList.add(new Stock("Whipped Cream", 1.00));

        Collections.sort(stockList);
    }

    public void recstock() {
        stockList.forEach(Stock::restock);
    }

    void make(Drink drink, Runnable OnError, Runnable OnSuccess) {
        if (!canMake(drink)) {
            OnError.run();
            return;
        }
        OnSuccess.run();
        make(drink);
    }

    public boolean canMake(Drink drink) {
        return getStream()
                .allMatch(stock -> stock.available(drink));
    }

    private void make(Drink drink) {
        stockList.forEach(stock -> stock.consume(drink));
    }

    double cost(Drink drink) {
        return getStream()
                .mapToDouble(stock -> stock.cost(drink))
                .sum();
    }

    private Stream<Stock> getStream() {
        return stockList.stream();
    }

    @Override
    public Iterator<Stock> iterator() {
        return stockList.iterator();
    }

    @Override
    public void forEach(Consumer<? super Stock> action) {
        stockList.forEach(action);
    }

    @Override
    public Spliterator<Stock> spliterator() {
        return stockList.spliterator();
    }


}