package sample.aop.provider;
import org.springframework.stereotype.Component;

@Component
public class Provider implements IProvider {
    @Override
    public double getPrice(String ref) {
        return 10.0;
    }
    @Override
    public boolean order(String ref, int qty) {
        System.out.println("Provider: commande " + qty + " de " + ref);
        return true;
    }
}
