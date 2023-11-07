package com.example.pdvcomerce.service;
import com.example.pdvcomerce.entity.Services;
import com.example.pdvcomerce.record.ProductRecord;
import com.example.pdvcomerce.record.ServicesRecord;
import com.example.pdvcomerce.repository.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicesService {

    @Autowired
    private ServicesRepository servicesRepository;

    @Transactional(readOnly = true)
    public List<ServicesRecord> findAllServices(){
        List<Services> services = servicesRepository.findAll();
        return services.stream().map(ServicesRecord::new).toList();
    }

    @Transactional
    public ServicesRecord insertServices(ServicesRecord servicesRecord){
        Services services = new Services();
        services.setName(servicesRecord.name());
        services.setDescription(servicesRecord.description());
        services.setPrice(servicesRecord.price());

        services = servicesRepository.save(services);
        return new ServicesRecord(services);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        servicesRepository.deleteById(id);
    }
}
