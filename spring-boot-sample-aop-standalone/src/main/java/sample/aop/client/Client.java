package sample.aop.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sample.aop.store.IFastLane;
import sample.aop.store.IJustHaveALook;
import sample.aop.store.ILane;

@Component
public class Client implements IRun {

    @Autowired
    IFastLane ifase;
    @Autowired
    ILane ilane;
    @Autowired
    IJustHaveALook ihave;

    int solde;

    @Override
    public void run() {
        ifase.oneShotOrder("banane",1,"carrefour city","10");
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
