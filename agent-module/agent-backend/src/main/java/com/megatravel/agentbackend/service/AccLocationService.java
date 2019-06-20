package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.model.AccLocation;

import java.util.List;

public interface AccLocationService {
    List<AccLocation> getAll();
    AccLocation getOneById(Long id);
    AccLocation addOne(AccLocation accLocation);
    AccLocation editOne(AccLocation accLocation);
    boolean deleteOne(AccLocation accLocation);
    boolean deleteById(Long id);
    //convertFromDto();
    //convertToDto();
}
