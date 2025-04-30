package com.bourkha.refactoring;

public enum Direction {
    NORTH(new Point(0, 1)),
    EAST(new Point(1, 0)),
    SOUTH(new Point(0, -1)),
    WEST(new Point(-1, 0));

    Direction(Point vector) {
        this.vector = vector;
    }

    Point vector;
    public Direction left() {
        int left = ordinal() - 1;
        if (left < 0) {
            left = values().length - 1;
        }
        return Direction.values()[left];
    }

    public Direction right() {
        int right = ordinal() + 1;
        if (right >= values().length) {
            right = 0;
        }
        return Direction.values()[right];
    }

}
