package view;

import model.Dot;
import model.Population;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    private int n_updates = 0;

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
            if(n_updates < dot.getMoveDirections().length) {
                dot.move(dot.getMoveDirections()[n_updates], 3);
            }
                g.fillOval((int) dot.getX(), (int) dot.getY(), 8, 8);
        }

        n_updates++;
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
