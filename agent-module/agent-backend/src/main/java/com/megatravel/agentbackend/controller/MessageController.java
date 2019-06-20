package com.megatravel.agentbackend.controller;

import com.megatravel.agentbackend.model.Message;
import com.megatravel.agentbackend.model.User;
import com.megatravel.agentbackend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/message")
public class MessageController {

    @Autowired
    MessageService messageService;
    @Autowired
    HttpSession httpSession;

    @GetMapping
    public ResponseEntity<List<Message>> getAll(){
        User agent = (User) httpSession.getAttribute("agent");
        if (agent == null){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(messageService.getAgentMessages(agent), HttpStatus.OK);
    }
}
