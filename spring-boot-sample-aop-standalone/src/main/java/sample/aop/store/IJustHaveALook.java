package sample.aop.store;

public interface IJustHaveALook {
    double getPrice(String ref);
    boolean isAvailable(String ref, int qty);
}
