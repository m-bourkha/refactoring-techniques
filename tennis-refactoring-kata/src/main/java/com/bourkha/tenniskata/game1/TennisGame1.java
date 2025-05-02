package com.bourkha.tenniskata.game1;

import com.bourkha.tenniskata.TennisGame;

public class TennisGame1 implements TennisGame {

    private final Player player1;
    private final Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        findPlayerByName(playerName).incrementScore();
    }

    private Player findPlayerByName(String playerName) {
        return playerName.equals(player1.getPlayerName()) ? player1 : player2;
    }

    public String getScore() {
        if (player1.getPlayerScore() == player2.getPlayerScore()) {
            return tieScore();
        } else if (isAdvantage(player1.getPlayerScore(), player2.getPlayerScore()) && hasOnePointAdvantage(player1.getPlayerScore(), player2.getPlayerScore())) {
            return advantageScore();
        } else {
            if (isAdvantage(player1.getPlayerScore(), player2.getPlayerScore()) && Math.abs(player1.getPlayerScore() - player2.getPlayerScore()) >= 2) {
                return winScore(player1.getPlayerScore(), player2.getPlayerScore());
            } else {
                return onGoingscore();
            }
        }
    }

    private boolean hasOnePointAdvantage(int player1Score, int player2Score) {
        return Math.abs(player1Score - player2Score) == 1;
    }

    private boolean isAdvantage(int player1Score1, int player2Score1) {
        return player1Score1 >= 4 || player2Score1 >= 4;
    }

    private String onGoingscore() {

        return ongoingScore(player1.getPlayerScore()) + "-" + ongoingScore(player2.getPlayerScore());
    }

    private static String ongoingScore(int playerScore) {
        return switch (playerScore) {
            case 0 ->  "Love";
            case 1 ->  "Fifteen";
            case 2 ->  "Thirty";
            case 3 ->  "Forty";
            default -> "";
        } ;
    }

    private String advantageScore() {
        int minusResult = player1.getPlayerScore() - player2.getPlayerScore();
        if (minusResult == 1) return "Advantage "+ player1.getPlayerName();
        return "Advantage "+ this.player2.getPlayerName();
    }

    private String winScore(int player1Score, int player2Score) {
        if (player1Score-player2Score >= 2) return "Win for " + player1.getPlayerName();
       else return "Win for " + this.player2.getPlayerName();
    }

    private String tieScore() {
        return switch (player1.getPlayerScore()) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }

}
