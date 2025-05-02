package com.bourkha.tenniskata.game1;

public class Win extends Result{
    public Win(Player player1, Player player2) {
        super(player1, player2);
    }

    @Override
    public String getScoreAsText() {
        if (player1.getScore() > player2.getScore()) return "Win for " + player1.getName();
        else return "Win for " + player2.getName();
    }
}