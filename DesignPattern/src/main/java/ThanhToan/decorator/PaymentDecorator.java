package ThanhToan.decorator;

import ThanhToan.strategy.PaymentStrategy;

public abstract class PaymentDecorator implements PaymentStrategy {
    protected PaymentStrategy paymentStrategy;

    public PaymentDecorator(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}