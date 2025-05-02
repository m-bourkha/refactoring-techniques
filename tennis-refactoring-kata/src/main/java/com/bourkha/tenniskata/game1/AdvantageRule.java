package com.bourkha.tenniskata.game1;

public class AdvantageRule implements GameRule {
    public AdvantageRule() {
    }

    @Override
    public boolean test(Integer player1Score, Integer player2Score) {
        return (player1Score >= 4 || player2Score >= 4)
                && hasOnePointAdvantage(player1Score, player2Score);
    }

    private boolean hasOnePointAdvantage(int player1Score, int player2Score) {
        return Math.abs(player1Score - player2Score) == 1;
    }

}