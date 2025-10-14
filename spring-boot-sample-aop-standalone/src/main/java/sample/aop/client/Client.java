package sample.aop.client;

import org.springframework.stereotype.Component;
import sample.aop.store.IFastLane;
import sample.aop.store.IJustHaveALook;
import sample.aop.store.ILane;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Client implements IRun {

    @Autowired
    IFastLane ifase;
    @Autowired
    ILane ilane;
    @Autowired
    IJustHaveALook ihave;

    int solde;

    public void run(int numscenario) {
        if (numscenario == 1) {
            System.out.println("Scénario 1");
            String ref = "A1";
            int qty = 2;
            String adresse = "10 rue de Rennes";
            String compte = "FR123456789";

            double prix = ihave.getPrice(ref);
            System.out.println("Prix de " + ref + " = " + prix);

            if (!ihave.isAvailable(ref, qty)) {
                // Normalement, c'est en stock donc n'apparait pas
                System.out.println("Article non dispo, réapprovisionnement...");
            }

            ifase.oneShotOrder(ref, qty, adresse, compte);
        }
        if (numscenario == 2) {
            System.out.println("Scénario 2");
            String adresse = "10 rue de Rennes";
            String compte = "FR123456789";

            ilane.addItemToCart("A1", 1);
            ilane.addItemToCart("B2", 3);
            ilane.pay(adresse, compte);
        }
    }

    @Override
    public void retirer(int r) {
        this.solde = this.solde - r;
    }

    @Override
    public void ajouter(int r) {
        this.solde = this.solde + r;
    }
}
