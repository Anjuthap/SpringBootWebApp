package com.example.SimpleWebApp.service;
import com.example.SimpleWebApp.model.Product;
import com.example.SimpleWebApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product addProduct(Product product) {
        repository.save(product);
        return product;
    }

    public Product updateProduct(Product product) {
        if (repository.existsById(product.getProdId())) {
            repository.save(product);
        }
        return product;
    }

    public void deleteProduct(int prodId) {
        repository.deleteById(prodId);
    }
}
