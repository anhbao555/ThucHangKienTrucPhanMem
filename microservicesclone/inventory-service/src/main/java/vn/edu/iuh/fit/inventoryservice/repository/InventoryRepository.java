package vn.edu.iuh.fit.inventoryservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.inventoryservice.model.Inventory;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String> {
}
