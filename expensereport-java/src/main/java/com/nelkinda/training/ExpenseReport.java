package com.nelkinda.training;

import java.util.Date;
import java.util.List;

enum ExpenseType {
    DINNER("Dinner", true, 5000),
    BREAKFAST("Breakfast", true, 1000),
    CAR_RENTAL("Car Rental", false, Integer.MAX_VALUE),
    LUNCH("Lauch", true , 2000);

    private final String name;
    private final boolean type;
    private final int limit;

    ExpenseType(String name, boolean type, int limit) {
        this.name = name;
        this.type = type;
        this.limit = limit;
    }

    String offLimit(Expense expense) {
        return expense.amount > limit ? "X" : " ";
    }

    String getName() {
        return name;
    }

    boolean isMeal() {
        return type;
    }
}

class Expense {
    ExpenseType type;
    int amount;

    boolean isMeal() {
        return type.isMeal();
    }
}

public class ExpenseReport {
    public void printReport(List<Expense> expenses) {
        printReport(expenses, new Date());
    }

    public void printReport(List<Expense> expenses, Date date) {
        int total = 0;
        int mealExpenses = 0;

        System.out.println("Expenses " + date);

        for (Expense expense : expenses) {
            if (expense.isMeal()) {
                mealExpenses += expense.amount;
            }

            String expenseName = expense.type.getName();

            String mealOverExpensesMarker = expense.type.offLimit(expense);

            System.out.println(expenseName + "\t" + expense.amount + "\t" + mealOverExpensesMarker);

            total += expense.amount;
        }

        System.out.println("Meal expenses: " + mealExpenses);
        System.out.println("Total expenses: " + total);
    }

}
