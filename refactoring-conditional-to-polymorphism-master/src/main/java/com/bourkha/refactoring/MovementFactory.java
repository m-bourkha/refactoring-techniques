package com.bourkha.refactoring;

public class MovementFactory {
    public static MovementCommand movementType(char command, Rover rover) {
        if(command == 'f') {
            return new Forward(rover);
        } else if (command == 'b') {
            return new Backward(rover);
        } else {
            return null;
        }

    }
}
