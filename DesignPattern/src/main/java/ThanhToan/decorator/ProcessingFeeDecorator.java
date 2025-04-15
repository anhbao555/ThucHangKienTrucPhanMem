package ThanhToan.decorator;

import ThanhToan.strategy.PaymentStrategy;

public class ProcessingFeeDecorator extends PaymentDecorator {
    public ProcessingFeeDecorator(PaymentStrategy paymentStrategy) {
        super(paymentStrategy);
    }

    public void pay(double amount) {
        double fee = amount * 0.02; // 2% processing fee
        System.out.println("Processing fee applied: " + fee);
        paymentStrategy.pay(amount + fee);
    }
}
