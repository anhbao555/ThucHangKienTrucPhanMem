package ThanhToan;

import ThanhToan.decorator.DiscountDecorator;
import ThanhToan.decorator.ProcessingFeeDecorator;
import ThanhToan.state.PaymentContext;
import ThanhToan.strategy.BankTransferPayment;
import ThanhToan.strategy.CreditCardPayment;
import ThanhToan.strategy.PayPalPayment;
import ThanhToan.strategy.PaymentStrategy;

public class PaymentSystem {
    public static void main(String[] args) {
        // Strategy Pattern Example
        PaymentStrategy creditCard = new CreditCardPayment();
        creditCard.pay(100);

        // Decorator Pattern Example
        PaymentStrategy discountedPayPal = new DiscountDecorator(new PayPalPayment());
        discountedPayPal.pay(100);

        PaymentStrategy feeAppliedBankTransfer = new ProcessingFeeDecorator(new BankTransferPayment());
        feeAppliedBankTransfer.pay(100);

        // State Pattern Example
        PaymentContext paymentContext = new PaymentContext();
        paymentContext.process(); // Pending -> Completed
        paymentContext.process();
    }
}
