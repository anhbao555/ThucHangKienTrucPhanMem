package QuanLyDonHang.state;


import QuanLyDonHang.model.OrderContext;

public class ProcessingState implements OrderState {
    public void handle(OrderContext context) {
        System.out.println("Packing and shipping order...");
        context.setState(new DeliveredState());
    }
}
