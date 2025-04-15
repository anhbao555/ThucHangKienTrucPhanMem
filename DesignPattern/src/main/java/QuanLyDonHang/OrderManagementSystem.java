package QuanLyDonHang;

import QuanLyDonHang.decorator.BasicOrderService;
import QuanLyDonHang.decorator.DiscountOrderServiceDecorator;
import QuanLyDonHang.decorator.OrderService;
import QuanLyDonHang.model.OrderContext;
import QuanLyDonHang.strategy.CreditCardPayment;
import QuanLyDonHang.strategy.PaymentStrategy;

public class OrderManagementSystem {
    public static void main(String[] args) {
        // State Pattern
        OrderContext order = new OrderContext();
        order.process(); // Checking order details...
        order.process(); // Packing and shipping order...
        order.process(); // Order delivered. Updating status.

        // Strategy Pattern
        PaymentStrategy payment = new CreditCardPayment();
        payment.pay(100.0);

        // Decorator Pattern
        OrderService orderService = new DiscountOrderServiceDecorator(new BasicOrderService());
        orderService.processOrder();
    }
}