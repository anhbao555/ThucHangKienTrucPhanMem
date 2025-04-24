package vn.edu.iuh.fit.shippingservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "shipping")
public class Shipping {
    @Id
    private String id;
    private String orderId;
    private String status; // PROCESSING, SHIPPED, DELIVERED
}
