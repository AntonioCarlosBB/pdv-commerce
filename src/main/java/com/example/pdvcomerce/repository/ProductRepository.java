package com.example.pdvcomerce.repository;

import com.example.pdvcomerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
