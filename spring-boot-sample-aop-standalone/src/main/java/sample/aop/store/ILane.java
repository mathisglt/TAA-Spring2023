package sample.aop.store;

public interface ILane {
    void addItemToCart(String ref, int qty);
    boolean pay(String adresse, String accountNumber);
}
