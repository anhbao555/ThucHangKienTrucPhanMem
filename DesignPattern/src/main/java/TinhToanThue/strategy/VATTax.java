package TinhToanThue.strategy;

public class VATTax implements TaxStrategy {
    public double calculateTax(double price) {
        return price * 0.1; // 10% VAT
    }
}