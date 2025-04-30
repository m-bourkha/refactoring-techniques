package com.nelkinda.training;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public record Expenses(List<Expense> expenses) implements Iterable<Expense> {

    int getTotal() {
        return expenses().stream()
                .mapToInt(Expense::amount)
                .sum();
    }

    int getMealExpenses() {
        return expenses().stream()
                .filter(Expense::isMeal)
                .mapToInt(Expense::amount).sum();
    }

    @Override
    public Iterator<Expense> iterator() {
        return expenses.iterator();
    }

    @Override
    public void forEach(Consumer<? super Expense> action) {
        expenses.forEach(action);
    }

    @Override
    public Spliterator<Expense> spliterator() {
        return expenses.spliterator();
    }
}