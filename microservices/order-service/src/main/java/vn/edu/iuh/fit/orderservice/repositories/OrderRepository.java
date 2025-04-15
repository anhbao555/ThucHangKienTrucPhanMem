package vn.edu.iuh.fit.orderservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.orderservice.entities.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
}
