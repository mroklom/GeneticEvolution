package model;

public class Dot {
    private double x;
    private double y;

    private double[] moveDirections;

    public void move(double angle, double length) {
        this.x += length * Math.cos(angle);
        this.y += length * Math.sin(angle);
    }

    public Dot(double x, double y, double[] moveDirections) {
        this.x = x;
        this.y = y;
        this.moveDirections = moveDirections;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double[] getMoveDirections() {
        return moveDirections;
    }

    public void setMoveDirections(double[] moveDirections) {
        this.moveDirections = moveDirections;
    }
}
