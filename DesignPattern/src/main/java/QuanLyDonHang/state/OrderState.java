package QuanLyDonHang.state;

import QuanLyDonHang.model.OrderContext;

public interface OrderState {
    void handle(OrderContext order);
}
