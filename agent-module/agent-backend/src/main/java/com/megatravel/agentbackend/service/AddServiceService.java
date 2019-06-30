package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.model.AddService;

import java.util.List;

public interface AddServiceService {
    List<AddService> getAll();
    AddService getOneById(Long id);
    AddService getOneByDbId(Long id);
    AddService addOne(AddService addService);
    AddService editOne(AddService addService);
    boolean deleteOne(AddService addService);
    boolean deleteById(Long id);
    void deleteAll();
    //convertFromDto();
    //convertToDto();
}
