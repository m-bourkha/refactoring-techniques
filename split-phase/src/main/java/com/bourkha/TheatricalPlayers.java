package com.bourkha;

import java.text.NumberFormat;
import java.util.Locale;

public class TheatricalPlayers {

    public String print(Invoice invoice) {

        return printTextInvoice(new InvoiceData(invoice.customer(), invoice.totalAmount(), invoice.earnedCredits()));
    }

    private static String printTextInvoice(InvoiceData invoiceData) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        var result = String.format("Statement for %s\n", invoiceData.customer());
        result += String.format("Amount owed is %s\n", format.format(invoiceData.totalAmount() / 100));
        result += String.format("You earned %s credits\n", invoiceData.earnedCredits());
        return result;
    }

    private  record InvoiceData(String customer, int totalAmount, int earnedCredits) {

    }
}
