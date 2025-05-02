package com.bourkha.tenniskata.game1;

public class Tie extends Result{
    public Tie(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public String getScoreAsText() {
        return switch (player1.getScore()) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }
}