package vn.edu.iuh.fit.shippingservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import vn.edu.iuh.fit.shippingservice.model.Shipping;

import java.util.Optional;

public interface ShippingRepository extends MongoRepository<Shipping, String> {
    Optional<Shipping> findByOrderId(String orderId);
}