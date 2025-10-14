package sample.simple.provider;
import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class Provider implements IProvider {
    private final Random random = new Random();
    @Override
    public double getPrice(String ref) {
        return 1 + (49 * random.nextDouble());
    }
    @Override
    public boolean order(String ref, int qty) {
        System.out.println("Provider: commande " + qty + " de " + ref);
        return true;
    }
}
