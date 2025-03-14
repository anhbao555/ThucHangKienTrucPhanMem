package QuanLyDonHang.state;


import QuanLyDonHang.model.OrderContext;

public class DeliveredState implements OrderState {
    public void handle(OrderContext context) {
        System.out.println("Order delivered. Updating status.");
    }
}
