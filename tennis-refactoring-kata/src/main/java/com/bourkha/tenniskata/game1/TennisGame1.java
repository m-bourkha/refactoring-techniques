package com.bourkha.tenniskata.game1;

import com.bourkha.tenniskata.TennisGame;

public class TennisGame1 implements TennisGame {

    private final Player player1;
    private final Player player2;
    private final Arbiter arbiter ;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
        arbiter = new Arbiter(player1,player2);
    }

    public void wonPoint(String playerName) {
        findPlayerByName(playerName).incrementScore();
    }

    private Player findPlayerByName(String playerName) {
        return playerName.equals(player1.getName()) ? player1 : player2;
    }

    public String getScore() {
        return arbiter.result(player1, player2).getScoreAsText();
    }

}


