package com.bourkha.tenniskata.game1;

public class TieRule implements GameRule{
    public TieRule() {
    }

    @Override
    public boolean test(Integer player1Score, Integer player2Score) {
        return player1Score == player2Score;
    }
}