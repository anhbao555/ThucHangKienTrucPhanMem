package TinhToanThue.state;

public class TaxContext {
    private TaxState taxState;

    public void setTaxState(TaxState taxState) {
        this.taxState = taxState;
    }

    public double applyTax(double price) {
        return taxState.applyTax(price);
    }
}
