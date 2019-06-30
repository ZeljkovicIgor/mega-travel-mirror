package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.model.AccPrice;
import com.megatravel.agentbackend.model.Accommodation;
import com.megatravel.agentbackend.repository.AccPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccPriceServiceImpl implements AccPriceService {

    @Autowired
    AccPriceRepository accPriceRepository;

    @Override
    public List<AccPrice> getAll() {
        return accPriceRepository.findAll();
    }

    @Override
    public AccPrice getOneById(Long id) {
        return accPriceRepository.findById(id).get();
    }

    @Override
    public AccPrice addOne(AccPrice accPrice) {
        return accPriceRepository.save(accPrice);
    }

    @Override
    public AccPrice editOne(AccPrice accPrice) {
        AccPrice accommodationPrice = getOneById(accPrice.getPriceId());
        accommodationPrice.setPriceEndDate(accPrice.getPriceEndDate());
        accommodationPrice.setPriceStartDate(accPrice.getPriceStartDate());
        accommodationPrice.setPriceValue(accPrice.getPriceValue());
        return accPriceRepository.save(accommodationPrice);
    }

    @Override
    public boolean deleteOne(AccPrice accPrice) {

        accPriceRepository.delete(accPrice);
        return (accPriceRepository.existsById(accPrice.getPriceId())?true:false);
    }

    @Override
    public boolean deleteById(Long id) {
        accPriceRepository.deleteById(id);
        return (accPriceRepository.existsById(id)?true:false);
    }
}
