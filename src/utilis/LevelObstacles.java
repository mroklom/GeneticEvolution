package utilis;

import model.Obstacle;


public class LevelObstacles {
    private static final LevelObstacles instance = new LevelObstacles();

    private final Obstacle[] OBSTACLES = new Obstacle[] {
            // Top border
            new Obstacle(
                        -10, -10,
                        WindowsProperties.WIDTH.getValue() + 20,20
                    ),
            // Left border
            new Obstacle(
                    -10, -10,
                    20,WindowsProperties.HEIGHT.getValue() + 20
            ),
            // Bottom border
            new Obstacle(
                    -10, WindowsProperties.HEIGHT.getValue() - 10,
                    WindowsProperties.WIDTH.getValue() + 20,20
            ),
            // right border
            new Obstacle(
                    WindowsProperties.WIDTH.getValue() - 10, -10,
                    20,WindowsProperties.HEIGHT.getValue() + 20
            )
    };

    //private constructor to avoid client applications to use constructor
    private LevelObstacles() {
    }

    public static LevelObstacles getInstance() {
        return instance;
    }

    public Obstacle[] getOBSTACLES() {
        return OBSTACLES;
    }
}
