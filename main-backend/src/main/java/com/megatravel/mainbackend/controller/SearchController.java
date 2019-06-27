package com.megatravel.mainbackend.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.mainbackend.dto.SearchAccommodationDTO;
import com.megatravel.mainbackend.model.Accommodation;
import com.megatravel.mainbackend.service.AccommodationService;
import com.megatravel.mainbackend.service.UserService;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

	 @Autowired
	 private UserService userService;
	
	 @Autowired 
	 private AccommodationService accommodationService;
	
	 
	@RequestMapping(value="/searchAccommodation/{city}/{accCapacity}/{startDate}/{endDate}/{accCategory}/{accType}" , method=RequestMethod.POST)
	 public ResponseEntity<?> search(@PathVariable("city") String city,@PathVariable("accCapacity") String accCapacity, @PathVariable("startDate") String startDate,
			 @PathVariable("endDate") String endDate, @PathVariable("accCategory") String accCategory,
			 @PathVariable("accType") String accType){
		// @PathVariable("startDate") String startDate,@PathVariable("endDate") String endDate,
		// @PathVariable("accCategory") String accCategory,
		// @PathVariable("accType") String accType
		 List<Accommodation> listAcc = new ArrayList<Accommodation>();
		 listAcc=accommodationService.findAll();
		 List<Accommodation> retAccDate  = new ArrayList<Accommodation>();
		 //lista smestaja koji su vec rezervisani
		 List<Accommodation> reservatedAcc = new ArrayList<Accommodation>();
		 //ono sto vracamo kao reyultat pretrage
		 List<Accommodation> returnList = new ArrayList<Accommodation>();
		 
		 //sa dodatnim ili bez dodatnih zahteva
		 List<Accommodation> ret = new ArrayList<Accommodation>();
		 
		 //broj kapaciteta ljudi
		 int broj=0;
		 if (city.equals("undefined") || city.equals("null")) {
	            city = "";
	     }
		 
		 DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	     Date dateS = null, dateE = null;
	        try {
	            dateS = format.parse(startDate);
	            dateE = format.parse(endDate);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
		 //parametri za naprednu pretragu ako su null ili undefined
	     //kategorija smestaja
	     if (accCategory.equals("undefined") || accCategory.equals("null")) {
	        	accCategory = "";
	     }
	     //tip smestaja
	     if (accType.equals("undefined") || accType.equals("null")) {
	    	 	accType = "";
	     }
		 //broj osoba, min 1 ne sme 0
		 if (accCapacity.equals("undefined") || accCapacity.equals("") || accCapacity.equals("null")) {
	            //ne bi trebalo nikad da udje
	            System.out.println("error serach...");
	           // retLodgings = lodgingService.findAll();
	     }else{
	    	 System.out.println("serach...");
	    	 broj=Integer.parseInt(accCapacity);
	    
	    	 returnList = accommodationService.findByCityAndAccCapacity(city, broj,accType,accCategory);
	    	 //returnList = accommodationService.findByCityAndAccCapacity2(city, broj,accType);
	    	 reservatedAcc = accommodationService.findByAccUnavailableDateStartBetweenAndAccUnavailableDateEndBetween(dateS, dateE,dateS, dateE);
	    	 int flag=0; //za proveru dozvoljenih
	    	for(Accommodation a1: returnList) {
	    		for(Accommodation a2: reservatedAcc) {
	    			if(a1.getAccId() == a2.getAccId()) {
	    				System.out.println("uslov"+(a1.getAccId() == a2.getAccId()));
	    				flag=1;
	    			}else {
	    				flag=0;
	    			}
	    			
	    		}
	    	
	    		System.out.println("serach...aaa"+a1.getAccId());
	    		if(flag==0) {
	    			
					retAccDate.add(a1);
	    		}
	    	}
	    	
	    	
	     }
		 
		 //ako ima dodatnih uslova
		 
		 System.out.println("date s + date e"+dateS+dateE);
		 System.out.println("Size"+returnList.size());
		 System.out.println("Size"+reservatedAcc.size());
		 
		 return new ResponseEntity<>(retAccDate,HttpStatus.OK);
	 }
	
	
	@RequestMapping(value="searchAccommodation", method=RequestMethod.GET)
	public ResponseEntity<List<Accommodation>> searchAccommodation(@RequestBody SearchAccommodationDTO searchAccommodation){
		return new ResponseEntity<>(accommodationService.search(searchAccommodation), HttpStatus.OK);
	}
		 
}
