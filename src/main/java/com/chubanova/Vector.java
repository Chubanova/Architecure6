package com.chubanova;

public class Vector {

    private final double x;
    private final double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Vector plus(Vector position, Vector velocity) {
        return new Vector(position.x+ velocity.x,position.y+ velocity.y);

    }
}
