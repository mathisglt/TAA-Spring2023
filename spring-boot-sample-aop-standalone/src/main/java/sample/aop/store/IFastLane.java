package sample.aop.store;

public interface IFastLane {
    boolean oneShotOrder(String ref, int qty, String adresse, String accountNumber);
}
