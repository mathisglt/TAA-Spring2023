package sample.simple.provider;

public interface IProvider {
    double getPrice(String ref);
    boolean order(String ref, int qty);
}