package TinhToanThue.decorator;

import TinhToanThue.strategy.TaxStrategy;

public abstract class TaxDecorator implements TaxStrategy {
    protected TaxStrategy taxStrategy;

    public TaxDecorator(TaxStrategy taxStrategy) {
        this.taxStrategy = taxStrategy;
    }
}
