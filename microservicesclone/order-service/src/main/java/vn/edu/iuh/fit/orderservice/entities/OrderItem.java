package vn.edu.iuh.fit.orderservice.entities;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItem {
    private String productId;
    private int quantity;
    private double price;
}
