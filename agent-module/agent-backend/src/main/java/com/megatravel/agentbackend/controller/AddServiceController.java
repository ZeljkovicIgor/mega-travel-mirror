package com.megatravel.agentbackend.controller;

import com.megatravel.agentbackend.model.AddService;
import com.megatravel.agentbackend.service.AddServiceService;
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
@RequestMapping(value = "/additionalservice")
public class AddServiceController {

    @Autowired
    AddServiceService addServiceService;

    @GetMapping
    public ResponseEntity<List<AddService>> getAll(){

        return new ResponseEntity<>(addServiceService.getAll(), HttpStatus.OK);
    }
}
