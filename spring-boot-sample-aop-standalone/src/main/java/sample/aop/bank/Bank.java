package sample.aop.bank;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import sample.aop.client.Client;

@Component
@Aspect
public class Bank implements IBank {

    @Override
    public boolean transfert(Client debiteur, Client receveur, int montant) {
        try {
            if (debiteur == null || receveur == null) return false;
            debiteur.retirer(montant);
            receveur.ajouter(montant);
            System.out.println("Transfert de " + montant + " effectué");
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
