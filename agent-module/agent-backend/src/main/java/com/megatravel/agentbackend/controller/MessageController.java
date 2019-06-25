package com.megatravel.agentbackend.controller;

import com.megatravel.agentbackend.dto.MessageDto;
import com.megatravel.agentbackend.model.Message;
import com.megatravel.agentbackend.model.User;
import com.megatravel.agentbackend.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
        /*
        User agent = (User) httpSession.getAttribute("agent");
        if (agent == null){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        */

        return new ResponseEntity<>(messageService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Message> getOne(@PathVariable(value = "id") long id){
        User agent = (User) httpSession.getAttribute("agent");
        //if (agent == null)
          //  return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        Message message = messageService.getOneById(id);

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping(value = "/reservation/{id}")
    public ResponseEntity<List<Message>> getReservationMessages(@PathVariable(value = "id") long id){
        User agent = (User) httpSession.getAttribute("agent");
        //if (agent == null)
        //  return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        List<Message> messageList = new ArrayList<>();
        messageList.addAll(messageService.getReservationMessagesById(id));

        return new ResponseEntity<>(messageList, HttpStatus.OK);
    }

    @PostMapping(value = "/send")
    public ResponseEntity<MessageDto> sendMessage(@RequestBody MessageDto messageDto){
        MessageDto message = messageService.sendMessage(messageDto);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
