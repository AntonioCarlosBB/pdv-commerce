package com.example.pdvcomerce.record;

import com.example.pdvcomerce.entity.Product;

public record ProductRecord(Long id, String name, String description, Double price, Integer quantity) {
    public ProductRecord(Product entity){
        this(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice(), entity.getQuantity());
    }
}
