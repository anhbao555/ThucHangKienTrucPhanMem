package vn.edu.iuh.fit.orderservice.services;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.orderservice.entities.Order;
import vn.edu.iuh.fit.orderservice.repositories.OrderRepository;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(Order order) {
        order.setCreatedAt(new Date());
        order.setStatus("CREATED");
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(String id) {
        return orderRepository.findById(id).orElse(null);
    }

    public Order updateOrder(String id, Order order) {
        Order existing = getOrderById(id);
        if (existing == null) return null;

        existing.setItems(order.getItems());
        existing.setTotalAmount(order.getTotalAmount());
        existing.setStatus(order.getStatus());

        return orderRepository.save(existing);
    }

    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }
}

