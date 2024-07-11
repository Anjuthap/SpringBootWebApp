package com.example.SimpleWebApp.controller;
import com.example.SimpleWebApp.model.Product;
import com.example.SimpleWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin
@RequestMapping("/api/products")
public class ProductController {

    public final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping // Read operation
    public List<Product> getProducts() {
        return service.getAllProducts();
    }

    @PostMapping // Create operation
    public Product addProduct(@RequestBody Product product) {
       return service.addProduct(product);
    }

    @PutMapping // Update operation
    public Product updateProduct(@RequestBody Product product) {
      return service.updateProduct(product);
    }

    @DeleteMapping("/{prodId}") // Delete operation
    public void deleteProduct(@PathVariable int prodId) {
        service.deleteProduct(prodId);
    }
}
