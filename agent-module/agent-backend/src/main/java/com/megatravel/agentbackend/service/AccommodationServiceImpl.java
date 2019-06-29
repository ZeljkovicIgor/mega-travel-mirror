package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.dto.AccommodationDto;
import com.megatravel.agentbackend.model.AccPrice;
import com.megatravel.agentbackend.model.AccType;
import com.megatravel.agentbackend.model.Accommodation;
import com.megatravel.agentbackend.model.AddService;
import com.megatravel.agentbackend.repository.*;
import com.megatravel.agentbackend.ws.AccLocationSoap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AccommodationServiceImpl implements AccommodationService {

    @Autowired
    AccommodationRepository accRepository;
    @Autowired
    AccTypeService accTypeService;
    @Autowired
    AccUnavailableService accUnavailableService;
    @Autowired
    AccPriceService accPriceService;
    @Autowired
    AccLocationService accLocationService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    AddServiceService addServiceService;
    @Autowired
    UserService userService;
    @Autowired
    SoapService soapService;
    @Autowired
    ReservationService reservationService;


    @Override
    public Accommodation getOneById(Long id) {


        return accRepository.findById(id).get();
    }

    @Override
    public Accommodation getOneByDbId(Long id) {
        return accRepository.findByAccDbId(id);
    }

    @Override
    public List<Accommodation> getAll() {
        return accRepository.findAll();
    }

    @Override
    public Accommodation addOne(Accommodation accommodation) {
        return accRepository.save(accommodation);
    }

    @Override
    public Accommodation addNewAccomodation(Accommodation accommodation) {



        return null;
    }

    @Override
    public Accommodation editOne(Accommodation accommodation) {
        return accRepository.save(accommodation);
    }

    @Override
    public boolean deleteOne(Accommodation accommodation) {
        accRepository.delete(accommodation);
        return true;
    }

    @Override
    public boolean deleteAccById(Long id) {
        Accommodation acc = getOneById(id);
        if (soapService.deleteAccommodation(acc)) {
            reservationService.deleteByAccommodation(acc);
            accRepository.delete(acc);
        }
        if (accRepository.existsById(id))
            return false;
        else
            return true;
    }

    @Override
    public Accommodation convertFromDto(AccommodationDto accDto) {
        Accommodation acc = new Accommodation();
        acc.setAccName(accDto.getAccName());
        acc.setAccDescription(accDto.getAccDescription());
        acc.setAccType(accTypeService.getOneById(accDto.getAccTypeId()));
        acc.setAccLocation(accLocationService.getOneById(accDto.getAccLocationId()));
        acc.setAccCancelPeriod((BigInteger.valueOf(accDto.getAccCancelPeriod())));
        acc.setAccCapacity(accDto.getAccCapacity());
        acc.setAccCategory(categoryService.getOneById(accDto.getAccCategoryId()));
        acc.setAccAgent(userService.getOneById(accDto.getAccAgentId()));
        acc.setAccDate(accDto.getAccDate());

        List<AccPrice> pricePlan = new ArrayList<>();
        for (Long accPriceId : accDto.getAccPricePlanId()) {
            pricePlan.add(accPriceService.getOneById(accPriceId));
        }
        acc.setAccPricePlan(pricePlan);
        List<AddService> accServices = new ArrayList<>();
        for (Long accServiceId : accDto.getAccServicesId()) {
            accServices.add(addServiceService.getOneById(accServiceId));
        }
        acc.setAccServices(accServices);


        return acc;
    }

    @Override
    public void deleteAll() {
        accRepository.deleteAll();
    }
}
