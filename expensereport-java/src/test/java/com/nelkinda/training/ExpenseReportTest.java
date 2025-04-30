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
        expenseReport = new ExpenseReport();
        out = new ApprovalUtilities().writeSystemOutToStringBuffer();
    }

    @Test
    void test_empty_report() {
        expenseReport.printReport(Collections.emptyList(), new Date(0));
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
                createExpense(ExpenseType.BREAKFAST, 1000),
                createExpense(ExpenseType.BREAKFAST, 1001),
                createExpense(ExpenseType.CAR_RENTAL, 50002)
        );

        expenseReport.printReport(expenses, new Date(0));
        Approvals.verify(out);

    }

    private static Expense createExpense(ExpenseType expenseType, int amount) {
        Expense expense = new Expense();
        expense.type = expenseType;
        expense.amount = amount;
        return expense;
    }
}