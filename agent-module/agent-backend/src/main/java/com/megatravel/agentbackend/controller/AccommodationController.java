package com.megatravel.agentbackend.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.megatravel.agentbackend.dto.AccommodationDto;
import com.megatravel.agentbackend.model.*;
import com.megatravel.agentbackend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/accommodation")

public class AccommodationController {

    @Autowired
    AccommodationService accommodationService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    AccTypeService accTypeService;
    @Autowired
    UserService userService;
    @Autowired
    AccPriceService accPriceService;
    @Autowired
    AccUnavailableService accUnavailableService;
    @Autowired
    AddServiceService addServiceService;
    @Autowired
    SoapService soapService;

    @PostMapping
    ResponseEntity<Accommodation> addNewAcccommodation(@RequestBody Accommodation accommodation, HttpServletRequest request){
        //uraditi validaciju ulaznih podataka
        Accommodation acc = new Accommodation();
        User agent = (User) request.getSession().getAttribute("agent");
        if(agent == null)
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        acc.setAccAgent(userService.getOneByUsername(agent.getUserUsername()));
        acc.setAccName(accommodation.getAccName());
        acc.setAccDescription(accommodation.getAccDescription());
        acc.setAccCancelPeriod(accommodation.getAccCancelPeriod());
        acc.setAccCapacity(accommodation.getAccCapacity());
        acc.setAccDate(new Date());
        acc.setAccCategory(categoryService.getOneById(accommodation.getAccCategory().getCategoryId()));
        acc.setAccType(accTypeService.getOneById(accommodation.getAccType().getAccTypeId()));
        AccLocation accLocation = new AccLocation();
        accLocation.setAddress(accommodation.getAccLocation().getAddress());
        accLocation.setCountry(accommodation.getAccLocation().getCountry());
        accLocation.setCity(accommodation.getAccLocation().getCity());
        acc.setAccLocation(accLocation);
        acc.setAccPricePlan(accommodation.getAccPricePlan());
        acc.setAccUnavailable(accommodation.getAccUnavailable());
        List<AccPrice> accPriceList = new ArrayList<>();
        for (AccPrice price : accommodation.getAccPricePlan() ) {
           accPriceList.add(accPriceService.addOne(price));
        }
        acc.setAccPricePlan(accPriceList);
        List<AccUnavailable> unavailableList = new ArrayList<>();
        for (AccUnavailable unav : accommodation.getAccUnavailable()) {
            unavailableList.add(accUnavailableService.addOne(unav));
        }
        acc.setAccUnavailable(unavailableList);
        List<AddService> addServiceList = new ArrayList<>();
        for (AddService addService :  accommodation.getAccServices()) {
            addServiceList.add(addServiceService.getOneById(addService.getServiceId()));
        }
        acc.setAccServices(addServiceList);
        Accommodation added = accommodationService.addOne(acc);
        try {
            Accommodation fromWS = soapService.createOneAccommodation(added);
            acc.setAccDbId(fromWS.getAccDbId());
            added = accommodationService.addOne(added);
        }catch (Exception e){
            System.out.println("Neuspesna sinhronizacija");
        }



        return new ResponseEntity<Accommodation>(added, HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<List<Accommodation>> getAllAccommodation(HttpServletRequest request){
        User agent = (User) request.getSession().getAttribute("agent");
        if (agent == null)
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        System.out.println("Get all");
        return new ResponseEntity<>(accommodationService.getAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    ResponseEntity<Accommodation> getOneAccommodation(@PathVariable("id") long id){
        return new ResponseEntity<>(accommodationService.getOneById(id), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    ResponseEntity<Accommodation> updateAccommodation(@PathVariable("id") long id, @RequestBody Accommodation accommodation){
        System.out.println("Stigao na izmenu id " + id);
        Accommodation acc = accommodationService.getOneById(id);
        if(acc != null)
            return new ResponseEntity<>(accommodationService.addOne(accommodation), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @DeleteMapping(value = "/{id}")
    ResponseEntity<String> deleteAcccommodation(@PathVariable("id") long id){

        if(accommodationService.deleteAccById(id))
            return new ResponseEntity<String>("Uspesno obrisan.", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Nije obrisan.", HttpStatus.NO_CONTENT);


    }
}
