package com.example.pdvcomerce.service;

import com.example.pdvcomerce.entity.Product;
import com.example.pdvcomerce.record.ProductRecord;
import com.example.pdvcomerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductRecord> findAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductRecord::new).toList();
    }

    @Transactional
    public ProductRecord insertProduct(ProductRecord productRecord){
        Product product = new Product();
        product.setName(productRecord.name());
        product.setDescription(productRecord.description());
        product.setPrice(productRecord.price());
        product.setQuantity(productRecord.quantity());

        product = productRepository.save(product);
        return new ProductRecord(product);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        productRepository.deleteById(id);
    }
}
