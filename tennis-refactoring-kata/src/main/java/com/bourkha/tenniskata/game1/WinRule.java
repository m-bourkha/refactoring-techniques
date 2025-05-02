package com.bourkha.tenniskata.game1;

public class WinRule implements GameRule{
    public WinRule() {
    }

    @Override
    public boolean test(Integer player1Score, Integer player2Score) {
        return (player1Score >= 4 || player2Score >= 4) && hasAtLeastTwoPointAdvantage(player1Score, player2Score);
    }

    private boolean hasAtLeastTwoPointAdvantage(int player1Score, int player2Score) {
        return Math.abs(player1Score - player2Score) >= 2;
    }
}