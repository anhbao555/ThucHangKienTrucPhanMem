package vn.edu.iuh.fit.shippingservice.service;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.shippingservice.model.Shipping;
import vn.edu.iuh.fit.shippingservice.repository.ShippingRepository;


@Service
public class ShippingService {

    @Autowired
    private ShippingRepository shippingRepository;

    private final CircuitBreaker circuitBreaker;
    private final Retry retry;

    @Autowired
    public ShippingService(CircuitBreakerRegistry circuitBreakerRegistry, RetryRegistry retryRegistry) {
        this.circuitBreaker = circuitBreakerRegistry.circuitBreaker("shippingService");
        this.retry = retryRegistry.retry("shippingService");
    }

    public Shipping createShipping(Shipping shipping) {
        return Try.ofSupplier(
                        Retry.decorateSupplier(retry, () -> {
                            shipping.setStatus("PROCESSING");
                            return shippingRepository.save(shipping);
                        })
                )
                .recover(throwable -> {
                    shipping.setStatus("FAILED");
                    return shipping;
                })
                .get();
    }

    public Shipping getShippingStatus(String orderId) {
        return Try.ofSupplier(
                        CircuitBreaker.decorateSupplier(circuitBreaker, () ->
                                shippingRepository.findByOrderId(orderId)
                                        .orElseThrow(() -> new RuntimeException("Shipping status not found"))
                        )
                )
                .recover(throwable -> null)
                .get();
    }

    public Shipping updateShippingStatus(String orderId, String status) {
        return Try.ofSupplier(
                        Retry.decorateSupplier(retry, () -> {
                            Shipping shipping = shippingRepository.findByOrderId(orderId)
                                    .orElseThrow(() -> new RuntimeException("Shipping status not found"));
                            shipping.setStatus(status);
                            return shippingRepository.save(shipping);
                        })
                )
                .recover(throwable -> null)
                .get();
    }
}
