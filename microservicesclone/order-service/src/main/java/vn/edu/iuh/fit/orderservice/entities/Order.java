package vn.edu.iuh.fit.orderservice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    private String id;

    private String customerId;

    private List<OrderItem> items;

    private double totalAmount;

    private String status;

    private Date createdAt;
}
