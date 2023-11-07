package com.example.pdvcomerce.record;

import com.example.pdvcomerce.entity.Services;

public record ServicesRecord(Long id, String name, String description, Double price) {
    public ServicesRecord(Services entity){
        this(entity.getId(), entity.getName(), entity.getDescription(), entity.getPrice());
    }
}
