package ThanhToan.state;

public class FailedPayment implements PaymentState {
    public void processPayment(PaymentContext context) {
        System.out.println("Payment failed. Please retry.");
    }
}
