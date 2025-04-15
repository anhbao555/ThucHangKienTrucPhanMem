package vn.edu.iuh.fit.productservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.productservice.entities.Product;

@Repository
public interface ProductRepostory extends MongoRepository<Product, Long> {
}
