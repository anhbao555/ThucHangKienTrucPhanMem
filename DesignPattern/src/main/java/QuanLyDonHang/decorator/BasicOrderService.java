package QuanLyDonHang.decorator;

public class BasicOrderService implements OrderService {
    public void processOrder() {
        System.out.println("Processing basic order...");
    }
}
