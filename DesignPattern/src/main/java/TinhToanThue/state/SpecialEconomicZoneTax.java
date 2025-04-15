package TinhToanThue.state;

public class SpecialEconomicZoneTax implements TaxState {
    public double applyTax(double price) {
        return price * 0.05; // 5% lower tax in special zones
    }
}
