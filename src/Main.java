import model.Population;
import utilis.WindowsProperties;
import view.Window;

public class Main {

    public static void main(String[] args) {
        Population population = new Population(
                20,
                500
        );
        new Window(WindowsProperties.WIDTH.getValue(), WindowsProperties.HEIGHT.getValue(), population);

    }
}
