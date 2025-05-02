package com.bourkha.tenniskata.game1;

public class Player {
    private int playerScore;
    private final String name;

    public Player(String name) {
        this.name = name;
        playerScore = 0;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public String getPlayerName() {
        return name;
    }

    void incrementScore() {
        this.playerScore++;
    }
}