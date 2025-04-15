package TinhToanThue;

import TinhToanThue.decorator.AdditionalSalesTax;
import TinhToanThue.state.NormalRegionTax;
import TinhToanThue.state.SpecialEconomicZoneTax;
import TinhToanThue.state.TaxContext;
import TinhToanThue.strategy.LuxuryTax;
import TinhToanThue.strategy.TaxStrategy;
import TinhToanThue.strategy.VATTax;

public class TaxCalculationSystem {
    public static void main(String[] args) {
        // Strategy Pattern Example
        TaxStrategy vatTax = new VATTax();
        System.out.println("VAT Tax on $100: " + vatTax.calculateTax(100));

        // Decorator Pattern Example
        TaxStrategy luxuryWithAdditionalTax = new AdditionalSalesTax(new LuxuryTax());
        System.out.println("Luxury Tax + Additional Tax on $100: " + luxuryWithAdditionalTax.calculateTax(100));

        // State Pattern Example
        TaxContext taxContext = new TaxContext();
        taxContext.setTaxState(new NormalRegionTax());
        System.out.println("Tax in normal region on $100: " + taxContext.applyTax(100));

        taxContext.setTaxState(new SpecialEconomicZoneTax());
        System.out.println("Tax in special zone on $100: " + taxContext.applyTax(100));
    }
}
