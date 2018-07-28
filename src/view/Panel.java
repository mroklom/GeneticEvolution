package view;

import model.Dot;
import model.Population;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    private int posX = -50;
    private int posY = -50;

    private Population population;

    public Panel(Population population) {
        this.population = population;
    }

    public void paintComponent(Graphics g) {
        // Reset background
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        // Draw the population
        g.setColor(Color.BLACK);
        for (Dot dot : population.getPopulation()) {
            dot.move(Math.random()*2*Math.PI, 1);
            g.fillOval((int) dot.getX(), (int) dot.getY(), 8, 8);
        }
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
