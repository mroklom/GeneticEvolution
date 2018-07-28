package view;

import model.Population;

import javax.swing.*;

public class Window extends JFrame {

    private Panel panel;

    public Window(int width, int height, Population population) {

        panel = new Panel(population);

        this.setSize(width, height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(panel);
        this.setVisible(true);

        animate();
    }

    private void animate() {
        while (true) {
        System.out.println("animation");

            panel.repaint();

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
