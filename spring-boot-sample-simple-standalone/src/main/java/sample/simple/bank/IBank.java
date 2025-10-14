package sample.simple.bank;

import sample.simple.client.Client;

public interface IBank {
    boolean transfert(Client debiteur, Client receveur,int montant);
}
