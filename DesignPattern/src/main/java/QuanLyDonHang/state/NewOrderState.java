package QuanLyDonHang.state;

import QuanLyDonHang.model.OrderContext;

public class NewOrderState implements OrderState {
    @Override
    public void handle(OrderContext context) {
        System.out.println("Checking order details...");
        context.setState(new ProcessingState());
    }
}
