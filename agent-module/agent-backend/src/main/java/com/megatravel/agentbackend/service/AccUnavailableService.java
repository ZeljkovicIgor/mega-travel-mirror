package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.model.AccUnavailable;

import java.util.List;

public interface AccUnavailableService {

    List<AccUnavailable> getAll();
    AccUnavailable getOneById(Long id);
    AccUnavailable addOne(AccUnavailable accUnavailable);
    AccUnavailable editOne(AccUnavailable accUnavailable);
    boolean deleteOne(AccUnavailable accUnavailable);
    boolean deleteById(Long id);
    //convertFromDto();
    //convertToDto();
}
