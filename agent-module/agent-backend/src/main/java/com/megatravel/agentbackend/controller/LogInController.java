package com.megatravel.agentbackend.controller;

import com.megatravel.agentbackend.dto.UserDto;
import com.megatravel.agentbackend.model.User;
import com.megatravel.agentbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LogInController {

    @Autowired
    UserService userService;


    @PostMapping("/login")
    public ResponseEntity<User> logIn(@RequestBody UserDto userDto, HttpSession session, HttpServletRequest request){
        System.out.println("Stigao" + userDto.getUserEmail());
        User agent = userService.logInUser(userDto);
        if (agent != null){
            session.setAttribute("agent", agent);
            System.out.println("Ulogovan je " + agent.getUserUsername());

            return new ResponseEntity<>(agent, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logOut(@RequestBody UserDto userDto){
       // httpSession.invalidate();
        userService.logOut();

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/isLogged")
    public ResponseEntity<?> loggedIn(HttpSession session, HttpServletRequest request){
        User agent = (User) session.getAttribute("agent");
        if (agent == null){
            System.out.println("Nije ulogovan");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            System.out.println("Ulogovan " + agent.getUserUsername());
            return new ResponseEntity<>(agent, HttpStatus.OK);
        }
    }
}
