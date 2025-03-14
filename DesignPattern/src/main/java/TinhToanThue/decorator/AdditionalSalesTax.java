package TinhToanThue.decorator;

import TinhToanThue.strategy.TaxStrategy;

public class AdditionalSalesTax extends TaxDecorator {
    public AdditionalSalesTax(TaxStrategy taxStrategy) {
        super(taxStrategy);
    }

    public double calculateTax(double price) {
        return taxStrategy.calculateTax(price) + (price * 0.05); // Additional 5%
    }
}
