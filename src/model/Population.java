package model;

import utilis.WindowsProperties;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Population {
    private int n_dots;
    private Dot[] population;

    public Population(int n_dots, int n_movements) {
        this.n_dots = n_dots;
        this.population = new Dot[n_dots];

        for (int i = 0; i < n_dots; i++) {
            double[] directions = new double[n_movements];
            for (int j = 0; j < n_movements; j++) {
                directions[j] = Math.random()*2*Math.PI;
            }
            
            population[i] = new Dot(
                    ThreadLocalRandom.current().nextInt(0, WindowsProperties.WIDTH.getValue()),
                    ThreadLocalRandom.current().nextInt(WindowsProperties.HEIGHT.getValue() - WindowsProperties.HEIGHT.getValue() / 5, WindowsProperties.HEIGHT.getValue()),
                    directions
            );
        }
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

    @Override
    public String toString() {
        return "Population{" +
                "n_dots=" + n_dots +
                ", population=" + Arrays.toString(population) +
                '}';
    }
}
