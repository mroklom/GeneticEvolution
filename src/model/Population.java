package model;

import utilis.WindowsProperties;
import view.Window;

import java.util.Arrays;

public class Population {
    private int n_dots;
    private Dot[] population;
    private int generation;

    private int numberOfMovementsDone;
    private int numberOfMovementsPerGeneration;

    public Population(int n_dots, int n_movements) {
        this.n_dots = n_dots;
        this.population = new Dot[n_dots];
        this.generation = 0;
        this.numberOfMovementsDone = 0;
        this.numberOfMovementsPerGeneration = n_movements;

        for (int i = 0; i < n_dots; i++) {
            double[] directions = new double[numberOfMovementsPerGeneration];
            for (int j = 0; j < numberOfMovementsPerGeneration; j++) {
                directions[j] = Math.random()*2*Math.PI;
            }
            
            population[i] = new Dot(
                    WindowsProperties.WIDTH.getValue() / 2,
                    WindowsProperties.HEIGHT.getValue() - WindowsProperties.HEIGHT.getValue() / 7,
                    directions
            );
        }
    }

    public void runGeneration(Window window) {
        System.out.println("running generation " + generation);

        while(numberOfMovementsDone <= numberOfMovementsPerGeneration) {
            // update all dot of one step
            for (Dot dot : population) {
                // If the point is not dead
                if (!dot.isDead()) {

                    if(numberOfMovementsDone == numberOfMovementsPerGeneration) {
                        dot.setDead(true);
                    } else {
                        boolean hasMove = dot.move(dot.getMoveDirections()[numberOfMovementsDone], 1);

                        // If the dot encountered an obstacle or if it was its last move
                        if(!hasMove) {
                            dot.setDead(true);
                        }
                    }

                }
            }

            // repaint the view
            window.getPanel().setPopulation(this);
            window.getPanel().repaint();

            numberOfMovementsDone++;

            // Wait to make it fluid
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        generation++;
        createNewGeneration();
    }

    private void createNewGeneration() {
    }

    public int getN_dots() {
        return n_dots;
    }

    public void setN_dots(int n_dots) {
        this.n_dots = n_dots;
    }

    public Dot[] getPopulation() {
        return population;
    }

    public void setPopulation(Dot[] population) {
        this.population = population;
    }

    public int getGeneration() {
        return generation;
    }

    @Override
    public String toString() {
        return "Population{" +
                "n_dots=" + n_dots +
                ", population=" + Arrays.toString(population) +
                '}';
    }
}
