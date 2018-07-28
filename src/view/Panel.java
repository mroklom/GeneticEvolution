package view;

import model.Dot;
import model.Obstacle;
import model.Population;
import utilis.LevelObstacles;
import utilis.WindowsProperties;

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
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        // Draw the obstacles
        g.setColor(Color.BLACK);
        for(Obstacle obstacle : LevelObstacles.getInstance().getOBSTACLES()) {
            g.fillRect(obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeigth());
        }
        System.out.println('\n');

        // Draw the population
        g.setColor(Color.BLUE);
        for (Dot dot : population.getPopulation()) {

            // If the point is not dead
            if(!dot.isDead()) {
                // Move the dot is there is still movements to do
                if(n_updates < dot.getMoveDirections().length) {
                    dot.move(dot.getMoveDirections()[n_updates], 3);
                }
                // Kill the dot and paint it red
                else {
                    dot.setDead(true);
                    g.setColor(Color.RED);
                }

            } else {
                g.setColor(Color.RED);
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
