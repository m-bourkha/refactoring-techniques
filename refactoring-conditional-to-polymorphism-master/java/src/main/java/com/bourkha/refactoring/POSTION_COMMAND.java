package com.bourkha.refactoring;

import java.util.function.BiFunction;

public enum POSTION_COMMAND {
    FORWARD((Point p, Direction d) -> p.forward(d.vector)),
    BACKWARD((Point p, Direction d) -> p.backward(d.vector));

    private final BiFunction<Point, Direction, Point> directionFunction;

    POSTION_COMMAND(BiFunction<Point, Direction, Point> directionFunction) {
        this.directionFunction = directionFunction;
    }

   static POSTION_COMMAND of(char c) {
        return c == 'f' ? POSTION_COMMAND.FORWARD : POSTION_COMMAND.BACKWARD;
    }

    Point execute(Point point, Direction direction) {
        return this.directionFunction.apply(point,direction);
    }



}
