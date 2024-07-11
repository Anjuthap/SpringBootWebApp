package com.example.SimpleWebApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SimpleWebApp.model.Product;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
