package com.nelkinda.training;

import org.approvaltests.ApprovalUtilities;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.Date;
import java.util.List;

class ExpenseReportTest {

    private ExpenseReport expenseReport;
    private ByteArrayOutputStream out;

    @BeforeEach
    void setUp() {

        out = new ApprovalUtilities().writeSystemOutToStringBuffer();
    }

    @Test
    void test_empty_report() {
        expenseReport = new ExpenseReport(new Expenses(Collections.emptyList()));
        expenseReport.printReport(new Date(0));
        Approvals.verify(out.toString());
    }

    /**
     * DINNER  5000
     * DINNER  5001
     * BREAKFAST 1000
     * BREAKFAST 1001
     * CAR_RENTAL
     */

    @Test
    void test_diverse_expenses() {
        List<Expense> expenses = List.of(createExpense(ExpenseType.DINNER, 5000),
                createExpense(ExpenseType.DINNER, 5001),
                createExpense(ExpenseType.LUNCH, 2000),
                createExpense(ExpenseType.LUNCH, 2001),
                createExpense(ExpenseType.BREAKFAST, 1000),
                createExpense(ExpenseType.BREAKFAST, 1001),
                createExpense(ExpenseType.CAR_RENTAL, 50002)
        );
        expenseReport = new ExpenseReport(new Expenses(expenses));
        expenseReport.printReport(new Date(0));
        Approvals.verify(out);

    }

    private static Expense createExpense(ExpenseType expenseType, int amount) {

        return new Expense(expenseType, amount);
    }
}