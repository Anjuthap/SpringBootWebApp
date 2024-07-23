package com.example.SimpleWebApp.service;
import com.example.SimpleWebApp.model.Product;
import com.example.SimpleWebApp.repository.CategoryRepository;
import com.example.SimpleWebApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ProductService implements FileService {


    private final ProductRepository repository;
    private final CategoryService catergoryService;

    @Autowired
    public ProductService(ProductRepository repository, CategoryService categoryService) {
        this.repository = repository;
        this.catergoryService = categoryService;
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
        return null;
    }

    public void deleteProduct(int prodId) {
        repository.deleteById(prodId);
    }

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {
        //file name
        String name= file.getOriginalFilename();

        //full path
        String filePath=path+ File.separator+name;

        //create folder if not created
        File f = new File(path);
        if (!f.exists()){
            f.mkdir();
        }

        //file copy
        Files.copy(file.getInputStream(), Paths.get(filePath));

        return name;
    }
}
