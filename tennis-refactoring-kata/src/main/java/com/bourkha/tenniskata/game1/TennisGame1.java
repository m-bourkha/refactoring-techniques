package com.bourkha.tenniskata.game1;

import com.bourkha.tenniskata.TennisGame;

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
        if (playerName == "player1")
            player1Score += 1;
        else
            player2Score += 1;
    }

    public String getScore() {
        String score = "";
        if (player1Score == player2Score) {
            return tieScore();
        } else if (player1Score >= 4 || player2Score >= 4) {
            return deuceScore();
        } else {
           return onGoingscore();
        }
    }

    private String onGoingscore() {
        int tempScore;
        String score1 = "";
        for (int i = 1; i < 3; i++) {
            if (i == 1) tempScore = player1Score;
            else {
                score1 += "-";
                tempScore = player2Score;
            }

            switch (tempScore) {
                case 0:
                    score1 += "Love";
                    break;
                case 1:
                    score1 += "Fifteen";
                    break;
                case 2:
                    score1 += "Thirty";
                    break;
                case 3:
                    score1 += "Forty";
                    break;
            }
        }
        return score1;
    }

    private String deuceScore() {
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) return "Advantage player1";
        else if (minusResult == -1) return "Advantage player2";
        else if (minusResult >= 2) return "Win for player1";
        else return "Win for player2";
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
