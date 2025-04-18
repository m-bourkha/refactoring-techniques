package com.bourkha.refactoring;

public class Rover {

    public static final char FORWARD = 'f';
    public static final char BACKWARD = 'b';
    public static final char LEFT = 'l';
    public static final char RIGHT = 'r';
    private final ReportingModule reportingModule;
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
            if (command == FORWARD || command == BACKWARD) {
                currentPosition = POSTION_COMMAND.of(command).execute(currentPosition, currentDirection);
            } else if (command == LEFT || command == RIGHT) {
                currentDirection = DIRECTION_COMMAND.of(command).execute(currentDirection);

            } else
                throw new UnsupportedOperationException("Unsupported command " + command);
        }

        reportingModule.reportPosition(currentPosition);
        reportingModule.reportDirection(currentDirection);
}
}

