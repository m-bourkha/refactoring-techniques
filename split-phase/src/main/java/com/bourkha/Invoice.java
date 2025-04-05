package com.bourkha;

import java.util.List;

public class Invoice {

    public String customer;
    public List<Performance> performances;

    public Invoice(String customer, List<Performance> performances) {
        this.customer = customer;
        this.performances = performances;
    }

    int getTotalAmount() {
        var totalAmount = 0;
        for (var perf : performances) {
            var thisAmount = perf.getThisAmount();
            totalAmount += thisAmount;
        }
        return totalAmount;
    }

    int getVolumeCredits() {
        var volumeCredits = 0;
        for (var perf : performances) {

            var thisCredits = perf.getThisCredits();
            volumeCredits += thisCredits;
        }
        return volumeCredits;
    }
}
