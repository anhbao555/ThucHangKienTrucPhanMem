package QuanLyDonHang.state;

import QuanLyDonHang.model.OrderContext;

public class CanceledState implements OrderState {
    public void handle(OrderContext context) {
        System.out.println("Order canceled. Processing refund.");
    }
}
