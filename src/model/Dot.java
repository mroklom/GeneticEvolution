package model;

import utilis.LevelObstacles;

import java.util.Arrays;

public class Dot {
    private double x;
    private double y;
    private int radius = 8;

    private double fitness;

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

    public static void fit(Dot dot) {

        Objective objective = Objective.getObjective();

        double distance = Math.sqrt(Math.pow(objective.getX() - dot.getX(),2) + Math.pow(objective.getY() - dot.getY(),2));

        double fitness =  1 / ( distance + 1 );

        dot.setFitness(fitness);
    }

    public Dot(double x, double y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
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

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    @Override
    public String toString() {
        return "Dot{" +
                "x=" + x +
                ", y=" + y +
                ", fitness=" + fitness +
                '}';
    }
}
