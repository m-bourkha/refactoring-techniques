package com.bourkha.tenniskata.game1;

import com.bourkha.tenniskata.TennisGame;

import java.util.Objects;

public class TennisGame1 implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (Objects.equals(playerName, player1Name))
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        if (player1Score == player2Score) {
            return tieScore();
        } else if (isAdvantage(player1Score, player2Score) && hasOnePointAdvantage(player1Score, player2Score)) {
            return advantageScore();
        } else if(isAdvantage(player1Score, player2Score) && Math.abs(player1Score-player2Score) >= 2) {
             return winScore(player1Score, player2Score);
        } else {
           return onGoingscore();
        }
    }

    private boolean hasOnePointAdvantage(int player1Score, int player2Score) {
        return Math.abs(player1Score - player2Score) == 1;
    }

    private boolean isAdvantage(int player1Score1, int player2Score1) {
        return player1Score1 >= 4 || player2Score1 >= 4;
    }

    private String onGoingscore() {

        return ongoingScore(player1Score) + "-" + ongoingScore(player2Score);
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
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) return "Advantage "+player1Name;
        return "Advantage "+ player2Name;
    }

    private String winScore(int player1Score, int player2Score) {
        if (player1Score-player2Score >= 2) return "Win for " + player1Name;
       else return "Win for " + player2Name;
    }

    private String tieScore() {
        return switch (player1Score) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
    }
}
