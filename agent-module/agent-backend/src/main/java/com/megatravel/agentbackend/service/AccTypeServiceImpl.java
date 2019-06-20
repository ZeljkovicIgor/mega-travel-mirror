package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.model.AccType;
import com.megatravel.agentbackend.repository.AccTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccTypeServiceImpl implements AccTypeService {

    @Autowired
    AccTypeRepository accTypeRepository;

    @Override
    public List<AccType> getAll() {
        return accTypeRepository.findAll();
    }

    @Override
    public AccType getOneById(Long id) {
        return accTypeRepository.getOne(id);
    }

    @Override
    public AccType addOne(AccType accType) {
        return accTypeRepository.save(accType);
    }

    @Override
    public AccType editOne(AccType accType) {
        AccType accomodationType = getOneById(accType.getAccTypeId());
        accomodationType.setAccTypeName(accType.getAccTypeName());
        return accomodationType;
    }

    @Override
    public boolean deleteOne(AccType accType) {

        accTypeRepository.delete(accType);
        return (accTypeRepository.existsById(accType.getAccTypeId())?true:false);
    }

    @Override
    public boolean deleteById(Long id) {
        accTypeRepository.deleteById(id);
        return (accTypeRepository.existsById(id)?true:false);
    }
}
