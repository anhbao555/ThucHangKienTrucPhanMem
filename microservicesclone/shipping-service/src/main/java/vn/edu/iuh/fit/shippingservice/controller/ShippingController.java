package vn.edu.iuh.fit.shippingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.shippingservice.model.Shipping;
import vn.edu.iuh.fit.shippingservice.repository.ShippingRepository;
import vn.edu.iuh.fit.shippingservice.service.ShippingService;

import java.util.Optional;

@RestController
@RequestMapping("/api/shipping")
public class ShippingController {

    @Autowired
    private ShippingService shippingService;

    @PostMapping
    public ResponseEntity<Shipping> createShipping(@RequestBody Shipping shipping) {
        Shipping createdShipping = shippingService.createShipping(shipping);
        return ResponseEntity.ok(createdShipping);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Shipping> getShippingStatus(@PathVariable String orderId) {
        return ResponseEntity.ok(shippingService.getShippingStatus(orderId));
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Shipping> updateShippingStatus(@PathVariable String orderId, @RequestParam String status) {
        Shipping updatedShipping = shippingService.updateShippingStatus(orderId, status);
        return ResponseEntity.ok(updatedShipping);
    }
}

