package com.example.SimpleWebApp.controller;

import com.example.SimpleWebApp.model.Category;
import com.example.SimpleWebApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Category> getCategories() {
        return service.getAllCategories();
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return service.addCategory(category);
    }

    @PutMapping
    public Category updateCategory(@RequestBody Category category) {
        return service.updateCategory(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id) {
        service.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
