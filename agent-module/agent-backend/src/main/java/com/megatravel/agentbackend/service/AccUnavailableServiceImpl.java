package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.model.AccUnavailable;
import com.megatravel.agentbackend.repository.AccTypeRepository;
import com.megatravel.agentbackend.repository.AccUnavailableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccUnavailableServiceImpl implements AccUnavailableService {

    @Autowired
    AccUnavailableRepository accUnavailableRepository;

    @Override
    public List<AccUnavailable> getAll() {
        return accUnavailableRepository.findAll();
    }

    @Override
    public AccUnavailable getOneById(Long id) {
        return accUnavailableRepository.findById(id).get();
    }

    @Override
    public AccUnavailable addOne(AccUnavailable accUnavailable) {
        return accUnavailableRepository.save(accUnavailable);
    }

    @Override
    public AccUnavailable editOne(AccUnavailable accUnavailable) {
        if(accUnavailableRepository.existsById(accUnavailable.getUnavId()))
            return accUnavailableRepository.save(accUnavailable);
        else
            return null;
    }

    @Override
    public boolean deleteOne(AccUnavailable accUnavailable) {
        accUnavailableRepository.delete(accUnavailable);
        return (accUnavailableRepository.existsById(accUnavailable.getUnavId())?true:false);
    }



    @Override
    public boolean deleteById(Long id) {
        accUnavailableRepository.deleteById(id);
        return (accUnavailableRepository.existsById(id)?true:false);
    }
}
