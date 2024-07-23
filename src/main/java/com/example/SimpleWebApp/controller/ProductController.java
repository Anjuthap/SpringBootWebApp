package com.example.SimpleWebApp.controller;
import com.example.SimpleWebApp.model.Product;
import com.example.SimpleWebApp.service.ProductService;
import com.example.SimpleWebApp.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController

@CrossOrigin
@RequestMapping("/api/products/categoryID/product")
public class ProductController {
    @Autowired
    private FileService fileService;

    @Value("${project.image")
    private String path;

    public final ProductService service;

    @Autowired
    public ProductController(ProductService service) { //DependencyInjection
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
    @PostMapping("/upload")
    public ResponseEntity<Product> fileUpload(
            @RequestParam("image") MultipartFile image
            ){
        String fileName = null;
        try {
            fileName = this.fileService.uploadImage(path,image);
        } catch (IOException e) {
            e.printStackTrace();

           return new ResponseEntity<>(new Product(null,"Image is not uploaded due to some error"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new Product(fileName,"Image is successfully uploaded"), HttpStatus.OK);

    }
}
