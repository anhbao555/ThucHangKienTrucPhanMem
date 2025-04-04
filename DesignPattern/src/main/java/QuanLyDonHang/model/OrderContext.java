package QuanLyDonHang.model;

import QuanLyDonHang.state.NewOrderState;
import QuanLyDonHang.state.OrderState;

public class OrderContext {
    private OrderState state;

    public OrderContext() {
        this.state = new NewOrderState();
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void process() {
        state.handle(this);
    }
}
