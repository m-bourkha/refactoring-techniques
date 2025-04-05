package com.bourkha;

import java.text.NumberFormat;
import java.util.Locale;

public class TheatricalPlayers {

    public String print(Invoice invoice) {
        InvoiceData invoiceData = new InvoiceData(invoice.customer, invoice.getTotalAmount(), invoice.getVolumeCredits());
        return textPrinter(invoiceData);
    }

    private static String textPrinter(InvoiceData invoiceData) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        var result = String.format("Statement for %s\n", invoiceData.customer());
        result += String.format("Amount owed is %s\n", format.format(invoiceData.totalAmount() / 100));
        result += String.format("You earned %s credits\n", invoiceData.volumeCredits());
        return result;
    }

    private static record InvoiceData(String customer, int totalAmount, int volumeCredits) {
    }
}
