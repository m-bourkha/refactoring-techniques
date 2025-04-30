package com.bourkha.refactoring;

import java.util.Objects;

public class Rover {

    private final ReportingModule reportingModule;

    public Point getCurrentPosition() {
        return currentPosition;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    private Point currentPosition;
    private Direction currentDirection;

    public Rover(ReportingModule reportingModule) {
        this.reportingModule = reportingModule;
    }

    public void land() {
        currentPosition = new Point(0, 0);
        reportingModule.reportPosition(currentPosition);

        currentDirection = Direction.NORTH;
        reportingModule.reportDirection(currentDirection);
    }

    public void executeCommands(String commands) {
        for (char command : commands.toCharArray()) {
            if (command == 'f' || command == 'b') {
                currentPosition = Objects.requireNonNull(MovementFactory.movementType(command, this)).move();
            }

            else if(command == 'r' || command =='l') {
                currentDirection = Objects.requireNonNull(RotationFactory.getRotationCommand(command, this)).rotate();
            }
            else {
                throw new UnsupportedOperationException("Unsupported command " + command);
            }
        }

        reportingModule.reportPosition(currentPosition);
        reportingModule.reportDirection(currentDirection);
    }

}
