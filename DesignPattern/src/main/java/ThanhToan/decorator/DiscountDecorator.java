package ThanhToan.decorator;

import ThanhToan.strategy.PaymentStrategy;

public class DiscountDecorator extends PaymentDecorator {
    public DiscountDecorator(PaymentStrategy paymentStrategy) {
        super(paymentStrategy);
    }

    public void pay(double amount) {
        double discount = amount * 0.1; // 10% discount
        System.out.println("Discount applied: " + discount);
        paymentStrategy.pay(amount - discount);
    }
}
