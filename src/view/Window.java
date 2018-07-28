package view;

import model.Population;
import utilis.WindowsProperties;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private Panel panel;

    public Window(Population population) {

        panel = new Panel(population);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setLocationRelativeTo(null);

        this.setContentPane(panel);
        this.getContentPane().setSize(WindowsProperties.WIDTH.getValue(), WindowsProperties.HEIGHT.getValue());

        this.pack();


        Insets insets = this.getInsets();
        this.setSize(WindowsProperties.WIDTH.getValue() + insets.left + insets.right, WindowsProperties.HEIGHT.getValue() + insets.top + insets.bottom);
        this.setResizable(false);

        this.setVisible(true);

        animate();
    }

    private void animate() {
        while (true) {

            panel.repaint();

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
