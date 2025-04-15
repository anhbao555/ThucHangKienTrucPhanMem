package vn.edu.iuh.fit.productservice.services;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.productservice.entities.Product;
import vn.edu.iuh.fit.productservice.repositories.ProductRepostory;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepostory productRepostory;

    public ProductService(ProductRepostory productRepostory) {
        this.productRepostory = productRepostory;
    }

    public Product createProduct(Product product) {
        return productRepostory.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepostory.findAll();
    }

    public Product getProduct(Long id) {
        return productRepostory.findById(id).orElse(null);
    }

    public Product updateProduct(Long id, Product product) {
        Product p = getProduct(id);
        if (p == null) return null;
        p.setName(product.getName());
        p.setDescription(product.getDescription());
        p.setPrice(product.getPrice());
        p.setStock(product.getStock());
        return productRepostory.save(p);
    }

    public void deleteProduct(Long id) {
        productRepostory.deleteById(id);
    }
}
