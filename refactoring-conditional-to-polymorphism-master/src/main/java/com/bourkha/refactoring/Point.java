package com.bourkha.refactoring;

import java.util.Objects;

public class Point {
    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point forward(Point point) {
        return new Point(x + point.x, y + point.y);
    }

    public Point backward(Point point) {
        return new Point(x - point.x, y - point.y);
    }

    @Override
    public String toString() {
        return "{" + x + ", " + y + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
