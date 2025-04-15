package TinhToanThue.strategy;

public class LuxuryTax implements TaxStrategy {
    public double calculateTax(double price) {
        return price * 0.2; // 20% Luxury Tax
    }
}