package model;

import utilis.WindowsProperties;

public class Objective extends Dot{

    private static final Objective objective = new Objective(
            WindowsProperties.WIDTH.getValue() / 2,
            WindowsProperties.HEIGHT.getValue() / 7,
            16
    );

    private Objective(double x, double y, int radius) {
        super(x, y, radius);
    }

    public static Objective getObjective() {
        return objective;
    }
}
