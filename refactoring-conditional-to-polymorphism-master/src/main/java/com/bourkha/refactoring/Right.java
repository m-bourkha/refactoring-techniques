package com.bourkha.refactoring;

public class Right implements RotationCommand{
    private final Rover rover;

    public Right(Rover rover) {
        this.rover = rover;
    }

    @Override
    public Direction rotate() {
        return rover.getCurrentDirection().right();
    }
}
