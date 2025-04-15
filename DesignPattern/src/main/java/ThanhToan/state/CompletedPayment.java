package ThanhToan.state;

public class CompletedPayment implements PaymentState {
    public void processPayment(PaymentContext context) {
        System.out.println("Payment completed successfully.");
    }
}
