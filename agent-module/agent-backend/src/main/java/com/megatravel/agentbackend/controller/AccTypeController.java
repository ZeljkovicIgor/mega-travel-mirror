package com.megatravel.agentbackend.controller;

import com.megatravel.agentbackend.model.AccType;
import com.megatravel.agentbackend.service.AccTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/acctype")
public class AccTypeController {

    @Autowired
    AccTypeService accTypeService;

    @GetMapping
    public ResponseEntity<List<AccType>> getAll(){

        return new ResponseEntity<>(accTypeService.getAll(), HttpStatus.OK);
    }

}
