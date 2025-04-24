package vn.edu.iuh.fit.inventoryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.inventoryservice.model.Inventory;
import vn.edu.iuh.fit.inventoryservice.repository.InventoryRepository;
import vn.edu.iuh.fit.inventoryservice.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/update")
    public ResponseEntity<String> updateInventory(@RequestBody Inventory inventory) {
        inventoryService.updateInventory(inventory.getProductId(), inventory.getQuantity());
        return ResponseEntity.ok("Inventory updated");
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Inventory> getInventory(@PathVariable String productId) {
        return ResponseEntity.ok(inventoryService.getInventoryByProductId(productId));
    }
}

