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

import com.megatravel.mainbackend.model.AddService;
import com.megatravel.mainbackend.service.AddServiceService;



@RestController
@RequestMapping(value = "/service")
public class ServiceController{

	@Autowired
	private AddServiceService serviceService;
	
	@RequestMapping(value="/addService", method=RequestMethod.POST)
	public ResponseEntity<AddService> addService(@RequestBody AddService newService){
		AddService service = serviceService.save(newService);
		
		if(service == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(service, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getServices", method=RequestMethod.GET)
	public ResponseEntity<List<AddService>> getServices(){
		return new ResponseEntity<>(serviceService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateService/{id}", method=RequestMethod.PUT)
	public ResponseEntity<AddService> updateService(@RequestBody AddService service, @PathVariable("id") long id){
		AddService newService = serviceService.update(id, service);
		
		if(newService == null)
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(newService, HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteService/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<AddService> deleteService(@PathVariable("id") long id){
		serviceService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
