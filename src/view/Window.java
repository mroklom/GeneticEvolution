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
        this.setLocation(600, 100);

        this.setContentPane(panel);
        this.getContentPane().setSize(WindowsProperties.WIDTH.getValue(), WindowsProperties.HEIGHT.getValue());

        this.pack();

        Insets insets = this.getInsets();
        this.setSize(WindowsProperties.WIDTH.getValue() + insets.left + insets.right, WindowsProperties.HEIGHT.getValue() + insets.top + insets.bottom);

        this.setVisible(true);
    }

    public Panel getPanel() {
        return panel;
    }
}
