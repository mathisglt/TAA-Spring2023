package sample.simple.client;

import org.springframework.stereotype.Component;
import sample.simple.store.IFastLane;
import sample.simple.store.IJustHaveALook;
import sample.simple.store.ILane;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Client implements IRun{

    @Autowired
    IFastLane ifase;
    @Autowired
    ILane ilane;
    @Autowired
    IJustHaveALook ihave;

    int solde;

    @Override
    public void run() {
        System.out.println("Hello World");
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
