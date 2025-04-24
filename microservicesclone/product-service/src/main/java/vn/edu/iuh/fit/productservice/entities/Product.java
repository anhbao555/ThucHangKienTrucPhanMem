package vn.edu.iuh.fit.productservice.entities;

// entity/Product.java

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    private Long id;

    private String name;
    private String description;
    private Double price;
    private Integer stock;
}

