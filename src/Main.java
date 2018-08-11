import model.Population;
import view.Window;

public class Main {

    public static void main(String[] args) {
        Population population = new Population(
                2,
                500
        );
        Window window = new Window(population);

        while(population.getGeneration() < 1) {
            population.runGeneration(window);
        }
    }
}
