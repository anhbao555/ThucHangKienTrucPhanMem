package vn.edu.iuh.fit.inventoryservice.service;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.inventoryservice.model.Inventory;
import vn.edu.iuh.fit.inventoryservice.repository.InventoryRepository;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    private final CircuitBreaker circuitBreaker;
    private final Retry retry;

    @Autowired
    public InventoryService(CircuitBreakerRegistry circuitBreakerRegistry, RetryRegistry retryRegistry) {
        this.circuitBreaker = circuitBreakerRegistry.circuitBreaker("inventoryService");
        this.retry = retryRegistry.retry("inventoryService");
    }

    public void updateInventory(String productId, int quantity) {
        Try.runRunnable(
                Retry.decorateRunnable(retry, () -> {
                    Inventory inventory = inventoryRepository.findById(productId)
                            .orElseThrow(() -> new RuntimeException("Inventory not found"));
                    inventory.setQuantity(inventory.getQuantity() - quantity);
                    inventoryRepository.save(inventory);
                })
        ).onFailure(Throwable::printStackTrace);
    }

    public Inventory getInventoryByProductId(String productId) {
        return Try.ofSupplier(
                        CircuitBreaker.decorateSupplier(circuitBreaker, () ->
                                inventoryRepository.findById(productId)
                                        .orElseThrow(() -> new RuntimeException("Inventory not found"))
                        )
                )
                .recover(throwable -> null)
                .get();
    }
}
