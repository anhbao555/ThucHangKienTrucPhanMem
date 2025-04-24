package vn.edu.iuh.fit.productservice.controllers;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.productservice.entities.Product;
import vn.edu.iuh.fit.productservice.services.ProductService;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {

        this.productService = productService;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/{id}")
    @Retry(name = "default", fallbackMethod = "fallback")
    @CircuitBreaker(name = "default", fallbackMethod = "fallback")
    @RateLimiter(name = "default")
    @TimeLimiter(name = "default")
    public CompletableFuture<ResponseEntity<Product>> getProduct(@PathVariable Long id) {
        return CompletableFuture.supplyAsync(() -> {
            Product product = productService.getProduct(id);
            return ResponseEntity.ok(product);
        });
    }

    public CompletableFuture<ResponseEntity<Product>> fallback(String id, Throwable ex) {
        Product fallbackProduct = new Product(0L, "Fallback Product", "Unavailable", 0.0, 0);
        return CompletableFuture.completedFuture(ResponseEntity.ok(fallbackProduct));
    }
}
