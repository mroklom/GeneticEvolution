package model;

import utilis.LevelObstacles;

import java.util.Arrays;

public class Dot {
    private double x;
    private double y;
    private int radius = 8;

    private boolean dead = false;

    private double[] moveDirections;

    public boolean move(double angle, double length) {

        double newX = this.x + length * Math.cos(angle);
        double newY =this.y + length * Math.sin(angle);

        for (Obstacle obstacle : LevelObstacles.getInstance().getOBSTACLES()) {

            // Check if the new coordinates are in the obstacle
            boolean xIsInside = newX >= obstacle.getX() && newX <= obstacle.getX() + obstacle.getWidth();
            boolean yIsInside = newY >= obstacle.getY() && newY <= obstacle.getY() + obstacle.getHeigth();
            if(xIsInside && yIsInside) {
                return false;
            }
        }

        this.x = newX;
        this.y = newY;
        return true;
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

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
