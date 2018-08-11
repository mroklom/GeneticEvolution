package view;

import model.Dot;
import model.Obstacle;
import model.Population;
import utilis.LevelObstacles;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {

    private int posX = -50;
    private int posY = -50;

    private Population population;

    public Panel(Population population) {
        this.population = population;
    }

    public Population getPopulation() {
        return population;
    }

    public void setPopulation(Population population) {
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

        // Print each dot of the population
        for(Dot dot : population.getPopulation()) {
            if(dot.isDead()) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.BLUE);
            }

            g.fillOval((int) (dot.getX() - dot.getRadius() / 2), (int) (dot.getY() - dot.getRadius() / 2), dot.getRadius(), dot.getRadius());
        }



    }
}
