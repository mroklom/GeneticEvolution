package view;

import model.Dot;
import model.Obstacle;
import model.Population;
import utilis.LevelObstacles;

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

        // Draw the population
        for (Dot dot : population.getPopulation()) {
            // If the point is not dead
            if(!dot.isDead()) {
                // Move the dot is there is still movements to do
                if(n_updates < dot.getMoveDirections().length) {
                    boolean hasMove = dot.move(dot.getMoveDirections()[n_updates], 1);
                        if(!hasMove) {
                            dot.setDead(true);
                        }
                }
                // Kill the dot and paint it red
                else {
                    dot.setDead(true);
                }

            }

            if(dot.isDead()) {
                g.setColor(Color.RED);
            } else {
                g.setColor(Color.BLUE);
            }

            // Draw the point
            g.fillOval((int) (dot.getX() - dot.getRadius() / 2), (int) (dot.getY() - dot.getRadius() / 2), dot.getRadius(), dot.getRadius());
        }

        n_updates++;
    }
}
