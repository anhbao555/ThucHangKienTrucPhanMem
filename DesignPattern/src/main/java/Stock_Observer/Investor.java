package Stock_Observer;

public class Investor implements StockObserver {
    private String name;
    private Stock stock;

    public Investor(String name) {
        this.name = name;
    }

    @Override
    public void update() {
        if (this.stock == null) {
            System.out.println(name + " has no stock set.");
            return;
        }
        System.out.println(name + " received stock update: " + stock.getUpdate(this));
    }

    @Override
    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
