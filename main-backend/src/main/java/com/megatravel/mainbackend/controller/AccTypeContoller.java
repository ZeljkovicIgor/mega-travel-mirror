package com.megatravel.mainbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.megatravel.mainbackend.model.AccType;
import com.megatravel.mainbackend.service.AccTypeService;


@RestController
@RequestMapping(value= "/accType")
public class AccTypeContoller {

	@Autowired
	private AccTypeService accTypeService;

	
	@RequestMapping(value="/addAccType", method=RequestMethod.POST)
	public ResponseEntity<AccType> addAccType(@RequestBody AccType newAccType){
		AccType accType = accTypeService.save(newAccType);
		
		if(accType == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(accType, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getAccTypes", method=RequestMethod.GET)
	public ResponseEntity<List<AccType>> getAccTypes(){
		return new ResponseEntity<>(accTypeService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateAccType/{id}", method=RequestMethod.PUT)
	public ResponseEntity<AccType> updateAccType(@RequestBody AccType accType, @PathVariable("id") long id){
		AccType newAccType = accTypeService.update(id, accType);
		
		if(newAccType == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(newAccType, HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteAccType/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<AccType> deleteAccType(@PathVariable("id") long id){
		accTypeService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
