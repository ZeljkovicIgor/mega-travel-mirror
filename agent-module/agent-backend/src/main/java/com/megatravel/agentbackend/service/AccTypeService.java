package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.model.AccType;

import java.util.List;

public interface AccTypeService {
    List<AccType> getAll();
    AccType getOneById(Long id);
    AccType getOneByDbId(Long id);
    AccType addOne(AccType accType);
    AccType editOne(AccType accType);
    boolean deleteOne(AccType accType);
    boolean deleteById(Long id);
    void deleteAll();
    //convertFromDto();
    //convertToDto();
}
