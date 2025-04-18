package com.bourkha.refactoring;

import java.util.function.Function;

public enum DIRECTION_COMMAND {
    LEFT(direction -> direction.left()),
    RIGHT(direction -> direction.right());

    Function<Direction, Direction> directionFunction;

    DIRECTION_COMMAND(Function<Direction, Direction> directionFunction) {
        this.directionFunction = directionFunction;
    }
    static DIRECTION_COMMAND of(char command) {
        return command == 'l' ? DIRECTION_COMMAND.LEFT : DIRECTION_COMMAND.RIGHT;
    }
    Direction execute(Direction direction) {
        return directionFunction.apply(direction);
    }
}
