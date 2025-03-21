package Stock_Observer;

public class StockMain {
    public static void main(String[] args) {
        // Stock Market Example
        StockMarket stockMarket = new StockMarket();
        Investor investor1 = new Investor("Alice");
        Investor investor2 = new Investor("Bob");

        stockMarket.register(investor1);
        stockMarket.register(investor2);

        stockMarket.setPrice(100.5);
        stockMarket.setPrice(102.0);
    }
}
