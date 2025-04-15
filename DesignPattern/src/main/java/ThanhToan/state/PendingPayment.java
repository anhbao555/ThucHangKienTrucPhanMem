package ThanhToan.state;

public class PendingPayment implements PaymentState {
    public void processPayment(PaymentContext context) {
        System.out.println("Payment is pending...");
        context.setState(new CompletedPayment());
    }
}
