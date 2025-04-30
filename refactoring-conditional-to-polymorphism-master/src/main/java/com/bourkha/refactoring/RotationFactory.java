package com.bourkha.refactoring;

public class RotationFactory {
    public RotationFactory() {
    }

    static RotationCommand getRotationCommand(char command, Rover rover) {
        if (command == 'l') {
            return new Left(rover);
        } else if (command == 'r') {
            return new Right(rover);
        } else return null;
    }
}