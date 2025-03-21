package Stock_Observer;

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private List<StockObserver> observers = new ArrayList<>();
    private double price;

    @Override
    public void register(StockObserver observer) {
        observers.add(observer);
        observer.setStock(this);
    }

    @Override
    public void unregister(StockObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update();
        }
    }

    @Override
    public double getUpdate(StockObserver observer) {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }
}

