package com.nelkinda.training;

import lombok.Getter;

import java.util.Date;

@Getter
enum ExpenseType {
    DINNER("Dinner", true, 5000),
    BREAKFAST("Breakfast", true, 1000),
    CAR_RENTAL("Car Rental", false, Integer.MAX_VALUE),
    LUNCH("Lauch", true, 2000);


    private final String name;
    private final boolean type;
    private final int limit;

    ExpenseType(String name, boolean type, int limit) {
        this.name = name;
        this.type = type;
        this.limit = limit;
    }

    String getName() {
        return name;
    }

    boolean isMeal() {
        return type;
    }
}

record Expense(ExpenseType type, int amount) {

    @Override
    public String toString() {
        return type().getName() + "\t" + amount() + "\t" + offLimit();
    }

    boolean isMeal() {
        return type().isMeal();
    }

    String offLimit() {
        return amount() > type().getLimit() ? "X" : " ";
    }

}

public class ExpenseReport {

    private final Expenses expenses;

    public ExpenseReport(Expenses expenses) {
        this.expenses = expenses;
    }

    public void printReport() {
        printReport(new Date());
    }

    public void printReport(Date date) {

        printHeader(date);

        printDetails();

        printFooter();
    }

    private void printHeader(Date date) {
        System.out.println("Expenses " + date);
    }

    private  void printDetails() {
        this.expenses.forEach(System.out::println);
    }

    private  void printFooter() {
        System.out.println("Meal expenses: " + this.expenses.getMealExpenses());
        System.out.println("Total expenses: " + this.expenses.getTotal());
    }

}
