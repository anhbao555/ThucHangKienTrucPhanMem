package QuanLyDonHang.decorator;

public class DiscountOrderServiceDecorator implements OrderService {
    private OrderService orderService;

    public DiscountOrderServiceDecorator(OrderService orderService) {
        this.orderService = orderService;
    }

    public void processOrder() {
        orderService.processOrder();
        System.out.println("Applying discount to order.");
    }
}
