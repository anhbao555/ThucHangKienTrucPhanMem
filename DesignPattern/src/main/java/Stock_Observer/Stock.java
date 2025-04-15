package Stock_Observer;

public interface Stock {
    void register(StockObserver observer);
    void unregister(StockObserver observer);
    void notifyObservers();
    double getUpdate(StockObserver observer);
}

