package vn.edu.iuh.fit.paymentservice.service;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryRegistry;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.paymentservice.model.Payment;
import vn.edu.iuh.fit.paymentservice.repository.PaymentRepository;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final CircuitBreaker circuitBreaker;
    private final Retry retry;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, CircuitBreakerRegistry circuitBreakerRegistry, RetryRegistry retryRegistry) {
        this.paymentRepository = paymentRepository;
        this.circuitBreaker = circuitBreakerRegistry.circuitBreaker("paymentService");
        this.retry = retryRegistry.retry("paymentService");
    }

    public Payment processPayment(Payment payment) {
        System.out.println("⏳ Đang xử lý thanh toán cho orderId: " + payment.getOrderId());

        return Try.ofSupplier(
                        Retry.decorateSupplier(retry,
                                CircuitBreaker.decorateSupplier(circuitBreaker, () -> {
                                    simulateProcessingDelay();
                                    payment.setStatus("PAID");
                                    return paymentRepository.save(payment);
                                })
                        )
                )
                .recover(throwable -> {
                    System.err.println("Thanh toán thất bại: " + throwable.getMessage());
                    payment.setStatus("FAILED");
                    return payment;
                })
                .get();
    }

    public Payment getPaymentByOrderId(String orderId) {
        return Try.ofSupplier(
                        CircuitBreaker.decorateSupplier(circuitBreaker, () ->
                                paymentRepository.findByOrderId(orderId)
                                        .orElseThrow(() -> new RuntimeException("Payment not found"))
                        )
                )
                .recover(throwable -> {
                    System.err.println("Không tìm thấy payment cho orderId: " + orderId);
                    return null;
                })
                .get();
    }

    private void simulateProcessingDelay() {
        try {
            Thread.sleep(1000); // giả lập xử lý
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            // Log lỗi nếu cần thiết
            System.err.println("Thread interrupted during processing delay");
        }
    }
}
