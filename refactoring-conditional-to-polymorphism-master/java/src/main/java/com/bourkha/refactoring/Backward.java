package com.bourkha.refactoring;

public class Backward implements MovementCommand{

    private final Rover rover;

    public Backward(Rover rover) {
        this.rover = rover;
    }

    @Override
    public Point move() {
        return rover.getCurrentPosition().backward(rover.getCurrentDirection().vector);
    }
}
