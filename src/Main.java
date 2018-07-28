import model.Population;
import view.Window;

public class Main {

    public static final int WINDOW_WIDTH = 600;
    public static final int WINDOW_HEIGHT = 800;

    public static void main(String[] args) {

        Window window = new Window(WINDOW_WIDTH, WINDOW_HEIGHT, new Population(20, WINDOW_WIDTH, WINDOW_HEIGHT));

    }
}
