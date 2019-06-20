package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.model.AccLocation;
import com.megatravel.agentbackend.repository.AccLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccLocationServiceImpl implements AccLocationService {

    @Autowired
    AccLocationRepository accLocationRepository;

    @Override
    public List<AccLocation> getAll() {
        return accLocationRepository.findAll();
    }

    @Override
    public AccLocation getOneById(Long id) {
        return accLocationRepository.getOne(id);
    }

    @Override
    public AccLocation addOne(AccLocation accLocation) {
        return accLocationRepository.save(accLocation);
    }

    @Override
    public AccLocation editOne(AccLocation accLocation) {
        return accLocationRepository.save(accLocation);

    }

    @Override
    public boolean deleteOne(AccLocation accLocation) {
        accLocationRepository.delete(accLocation);
        return (accLocationRepository.existsById(accLocation.getLocId())?true:false);
    }

    @Override
    public boolean deleteById(Long id) {
        accLocationRepository.deleteById(id);
        return (accLocationRepository.existsById(id)?true:false);
    }
}
