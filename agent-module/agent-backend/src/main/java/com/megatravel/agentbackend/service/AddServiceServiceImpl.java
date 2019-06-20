package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.model.AddService;
import com.megatravel.agentbackend.repository.AddServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddServiceServiceImpl implements AddServiceService {

    @Autowired
    AddServiceRepository addServiceRepository;

    @Override
    public List<AddService> getAll() {
        return addServiceRepository.findAll();
    }

    @Override
    public AddService getOneById(Long id) {
        return addServiceRepository.getOne(id);
    }

    @Override
    public AddService addOne(AddService addService) {
        return addServiceRepository.save(addService);
    }

    @Override
    public AddService editOne(AddService addService) {
        return addServiceRepository.save(addService);
    }

    @Override
    public boolean deleteOne(AddService addService) {
        addServiceRepository.delete(addService);
        return (addServiceRepository.existsById(addService.getServiceId())?true:false);
    }

    @Override
    public boolean deleteById(Long id) {
        addServiceRepository.deleteById(id);
        return (addServiceRepository.existsById(id)?true:false);
    }
}
