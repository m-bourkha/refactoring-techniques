package com.bourkha;

public record Performance(Play play, int audience) {

    int credits() {
        var thisCredits = Math.max(audience() - 30, 0);
        if ("comedy".equals(play().type())) thisCredits += (int) Math.floor((double) audience() / 5);
        return thisCredits;
    }

    int amount() {
        var thisAmount = 40000;
        if (audience() > 30) {
            thisAmount += 1000 * (audience() - 30);
        }
        return thisAmount;
    }

}
