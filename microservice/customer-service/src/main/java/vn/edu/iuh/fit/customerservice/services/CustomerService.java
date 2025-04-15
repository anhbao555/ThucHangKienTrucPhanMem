package vn.edu.iuh.fit.customerservice.services;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.customerservice.entities.Customer;
import vn.edu.iuh.fit.customerservice.repositories.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public Customer create(Customer customer) {
        return repo.save(customer);
    }

    public List<Customer> getAll() {
        return repo.findAll();
    }

    public Customer getById(String id) {
        return repo.findById(id).orElse(null);
    }

    public Customer update(String id, Customer customer) {
        Customer c = getById(id);
        if (c == null) return null;
        c.setName(customer.getName());
        c.setEmail(customer.getEmail());
        c.setPhone(customer.getPhone());
        c.setAddress(customer.getAddress());
        return repo.save(c);
    }

    public void delete(String id) {
        repo.deleteById(id);
    }
}
