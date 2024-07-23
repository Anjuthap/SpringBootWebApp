package com.example.SimpleWebApp.service;

import com.example.SimpleWebApp.model.Category;
import com.example.SimpleWebApp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    public Category addCategory(Category category) {
        return repository.save(category);
    }

    public Category updateCategory(Category category) {
        if (repository.existsById(category.getId())) {
            return repository.save(category);
        }
        return null;
    }

    public void deleteCategory(int id) {
        repository.deleteById(id);
    }
}
