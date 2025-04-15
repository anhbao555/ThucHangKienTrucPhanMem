package TinhToanThue.state;

public class NormalRegionTax implements TaxState {
    public double applyTax(double price) {
        return price * 0.1; // 10% base tax
    }
}
