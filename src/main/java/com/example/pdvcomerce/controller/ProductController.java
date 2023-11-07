package com.example.pdvcomerce.controller;

import com.example.pdvcomerce.record.ProductRecord;
import com.example.pdvcomerce.record.ServicesRecord;
import com.example.pdvcomerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductRecord> getAll(){
        return productService.findAllProducts();
    }

    @PostMapping
    public ResponseEntity<ProductRecord> insertProduct(@RequestBody ProductRecord productRecord){
        productRecord = productService.insertProduct(productRecord);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(productRecord.id()).toUri();
        return ResponseEntity.created(uri).body(productRecord);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
