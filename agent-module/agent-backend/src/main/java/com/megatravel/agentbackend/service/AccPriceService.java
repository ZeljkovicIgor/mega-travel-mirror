package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.model.AccPrice;

import java.util.List;

public interface AccPriceService {
    List<AccPrice> getAll();
    AccPrice getOneById(Long id);
    AccPrice addOne(AccPrice accPrice);
    AccPrice editOne(AccPrice accPrice);
    boolean deleteOne(AccPrice accPrice);
    boolean deleteById(Long id);
    //convertFromDto();
    //convertToDto();
}
