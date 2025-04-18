package com.bourkha;

import java.util.List;

public record Invoice(String customer, List<Performance> performances) {

    int earnedCredits() {
        return performances().stream().mapToInt(Performance::credits).sum();
    }

    int totalAmount() {
        return performances().stream().mapToInt(Performance::amount).sum();
    }

}
