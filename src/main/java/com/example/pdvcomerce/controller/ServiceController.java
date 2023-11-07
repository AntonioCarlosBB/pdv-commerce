package com.example.pdvcomerce.controller;

import com.example.pdvcomerce.entity.Services;
import com.example.pdvcomerce.record.ProductRecord;
import com.example.pdvcomerce.record.ServicesRecord;
import com.example.pdvcomerce.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("service")
public class ServiceController {

    @Autowired
    private ServicesService servicesService;

    @GetMapping
    public List<ServicesRecord> getAll(){
        return servicesService.findAllServices();
    }

    @PostMapping
    public ResponseEntity<ServicesRecord> insertServices(@RequestBody ServicesRecord servicesRecord){
        servicesRecord = servicesService.insertServices(servicesRecord);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(servicesRecord.id()).toUri();
        return ResponseEntity.created(uri).body(servicesRecord);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        servicesService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
