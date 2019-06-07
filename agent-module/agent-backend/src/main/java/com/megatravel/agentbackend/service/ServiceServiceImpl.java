package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.model.Service;
import com.megatravel.agentbackend.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Service addService(Service service) {
        return serviceRepository.save(service);
    }

}
