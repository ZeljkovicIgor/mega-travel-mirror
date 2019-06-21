package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.client.MegaTravelClient;
import com.megatravel.agentbackend.model.*;
import com.megatravel.agentbackend.ws.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SoapServiceImpl implements SoapService {

    @Autowired
    MegaTravelClient client;

    @Override
    public Accommodation sendOneAccommodation(Accommodation acc) {
        AccommodationSoap accSoap = new AccommodationSoap();
        accSoap.setAccName(acc.getAccName());
        accSoap.setAccDescription(acc.getAccDescription());
        accSoap.setAccCapacity(acc.getAccCapacity());
        accSoap.setAccCancelPeriod(acc.getAccCancelPeriod());
        accSoap.setAccDate(acc.getAccDate());

        //Lokacija
        AccLocationSoap accLocationSoap = new AccLocationSoap();
        accLocationSoap.setAddress(acc.getAccLocation().getAddress());
        accLocationSoap.setCity(acc.getAccLocation().getCity());
        accLocationSoap.setCountry(acc.getAccLocation().getCountry());
        accLocationSoap.setXCoordinate(acc.getAccLocation().getXCoordinate());
        accLocationSoap.setYCoordinate(acc.getAccLocation().getYCoordinate());
        accSoap.setAccLocation(accLocationSoap);

        //Dodatni servisi
        List<AddService> addServiceList = acc.getAccServices();
        AddServiceSoap addServiceSoap = null;
        for (AddService addService : addServiceList){
            addServiceSoap = new AddServiceSoap();
            addServiceSoap.setServiceId(addService.getServiceDbId());
            addServiceSoap.setServiceName(addService.getServiceName());
            accSoap.getAccServices().add(addServiceSoap);
        }


        //Kategorija
        CategorySoap categorySoap = new CategorySoap();
        categorySoap.setCategoryId(acc.getAccCategory().getCategoryDbId());
        categorySoap.setCategoryName(acc.getAccCategory().getCategoryName());
        accSoap.setAccCategory(categorySoap);

        //Tip
        AccTypeSoap accTypeSoap = new AccTypeSoap();
        accTypeSoap.setAccTypeId(acc.getAccType().getAccTypeDbId());
        accTypeSoap.setAccTypeName(acc.getAccType().getAccTypeName());
        accSoap.setAccCategory(categorySoap);

        //Plan cena
        AccPriceSoap accPriceSoap = null;
        for (AccPrice accPrice : acc.getAccPricePlan()) {
            accPriceSoap = new AccPriceSoap();
            accPriceSoap.setPriceStartDate(accPrice.getPriceStartDate());
            accPriceSoap.setPriceEndDate(accPrice.getPriceEndDate());
            accPriceSoap.setPriceValue(accPrice.getPriceValue());
            accSoap.getAccPricePlan().add(accPriceSoap);
        }

        //Zauzetost

        AccUnavailableSoap accUnavailableSoap = null;
        for (AccUnavailable accUnavailable : acc.getAccUnavailable()) {
            accUnavailableSoap = new AccUnavailableSoap();
            accUnavailableSoap.setUnavailableStart(accUnavailable.getUnavailableStart());
            accUnavailableSoap.setUnavailableEnd(accUnavailable.getUnavailableEnd());
            accSoap.getAccUnavailable().add(accUnavailableSoap);
        }



        AddOneAccommodationResponse response = client.addOneAccommodation(accSoap);
        System.out.println(response.getAccDBId());
        acc.setAccDbId(response.getAccDBId());
        return acc;
    }
}
