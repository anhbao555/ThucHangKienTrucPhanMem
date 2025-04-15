package ThanhToan.strategy;

public class BankTransferPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Bank Transfer.");
    }
}
