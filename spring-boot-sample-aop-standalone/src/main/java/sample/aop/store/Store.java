package sample.aop.store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.aop.bank.IBank;
import sample.aop.provider.IProvider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Store implements IJustHaveALook, ILane, IFastLane {

    @Autowired
    IBank ibank;
    @Autowired
    IProvider provider;

    private Map<String,Integer> stock = new HashMap<>();

    public Store() {
        stock.put("A1", 5);
        stock.put("B2", 0);
    }

    @Override
    public double getPrice(String ref) { return provider.getPrice(ref); }
    @Override
    public boolean isAvailable(String ref, int qty) {
        return stock.getOrDefault(ref,0) >= qty;
    }

    @Override
    public boolean oneShotOrder(String ref, int qty, String adresse, String accountNumber) {
        if (!isAvailable(ref, qty)) {
            provider.order(ref, Math.max(10, qty));
        }
        stock.put(ref, stock.getOrDefault(ref,0) - qty);
        System.out.println("OneShotOrder : " + ref + " x" + qty);
        return true;
    }

    /* ILane */
    private List<String> cart = new ArrayList<>();
    @Override
    public void addItemToCart(String ref, int qty) { cart.add(ref + ":" + qty); }
    @Override
    public boolean pay(String adresse, String accountNumber) {
        System.out.println("Paiement pour " + cart);
        cart.clear();
        return true;
    }
}
