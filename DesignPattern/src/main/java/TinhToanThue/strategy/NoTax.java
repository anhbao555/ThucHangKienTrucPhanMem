package TinhToanThue.strategy;

public class NoTax implements TaxStrategy {
    public double calculateTax(double price) {
        return 0;
    }
}
