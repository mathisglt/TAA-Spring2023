package sample.aop.bank;

import sample.aop.client.Client;

public interface IBank {
    boolean transfert(Client debiteur, Client receveur,int montant);
}
