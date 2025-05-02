package com.bourkha.tenniskata.game1;

public class Advantage extends Result {
    public Advantage(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public String getScoreAsText() {
        if (player1.getScore() > player2.getScore()) return "Advantage " + player1.getName();
        return "Advantage " + player2.getName();
    }
}