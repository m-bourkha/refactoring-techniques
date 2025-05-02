package com.bourkha.tenniskata.game1;

public class Ongoing extends Result {
    public Ongoing(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public String getScoreAsText() {
        return ongoingScore(player1.getScore()) + "-" + ongoingScore(super.player2.getScore());
    }

    String ongoingScore(int playerScore) {
        return switch (playerScore) {
            case 0 -> "Love";
            case 1 -> "Fifteen";
            case 2 -> "Thirty";
            case 3 -> "Forty";
            default -> "";
        };
    }
}