import model.Population;
import utilis.WindowsProperties;
import view.Window;

public class Main {

    public static void main(String[] args) {
        Population population = new Population(
                50,
                1000
        );
        new Window(population);

    }
}
