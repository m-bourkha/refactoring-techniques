package com.nelkinda.training;

import org.approvaltests.ApprovalUtilities;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseReportTest {

    private ExpenseReport expenseReport;
    private ByteArrayOutputStream out ;
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
}