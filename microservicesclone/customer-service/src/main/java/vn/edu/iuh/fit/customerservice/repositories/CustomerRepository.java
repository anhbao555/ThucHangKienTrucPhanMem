package vn.edu.iuh.fit.customerservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.customerservice.entities.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
}
