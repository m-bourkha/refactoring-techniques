package com.bourkha.refactoring;

public class Forward implements MovementCommand{

    private final Rover rover;

    public Forward(Rover rover) {
        this.rover = rover;
    }

    @Override
    public Point move() {
        return rover.getCurrentPosition().forward(rover.getCurrentDirection().vector);
    }
}
