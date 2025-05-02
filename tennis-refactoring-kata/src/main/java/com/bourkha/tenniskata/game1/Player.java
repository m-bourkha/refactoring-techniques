package com.bourkha.tenniskata.game1;

public class Player {
    private int score;
    private final String name;

    public Player(String name) {
        this.name = name;
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    void incrementScore() {
        this.score++;
    }
}