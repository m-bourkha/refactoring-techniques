package com.bourkha.refactoring;

public class Left implements RotationCommand{

    private final Rover rover;

    public Left(Rover rover) {
        this.rover = rover;
    }

    @Override
    public Direction rotate() {
        return rover.getCurrentDirection().left();
    }
}
