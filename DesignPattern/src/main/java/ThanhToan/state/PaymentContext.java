package ThanhToan.state;

public class PaymentContext {
    private PaymentState state;

    public PaymentContext() {
        this.state = new PendingPayment();
    }

    public void setState(PaymentState state) {
        this.state = state;
    }

    public void process() {
        state.processPayment(this);
    }
}
