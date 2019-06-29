package com.megatravel.agentbackend.controller;

import com.megatravel.agentbackend.dto.UserDto;
import com.megatravel.agentbackend.model.User;
import com.megatravel.agentbackend.service.SoapService;
import com.megatravel.agentbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpRequest;
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
    @Autowired
    SoapService soapService;


    @PostMapping("/login")
    public ResponseEntity<User> logIn(@RequestBody UserDto userDto, HttpServletRequest request){
        System.out.println("Stigao" + userDto.getUserUsername());


        if (!soapService.logInSync(userDto.getUserUsername(), userDto.getUserPassword()))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        User agent = userService.getOneByUsername(userDto.getUserUsername());

        if (agent == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else{
            agent.setUserPassword("");
            request.getSession().setAttribute("agent", agent);
            return new ResponseEntity<>(agent, HttpStatus.OK);
        }

    }

    @PostMapping("/logout")
    public ResponseEntity<?> logOut(HttpServletRequest request){
        request.getSession().invalidate();
        userService.logOut();

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/isLogged")
    public ResponseEntity<?> loggedIn(HttpServletRequest request){
        User agent = (User) request.getSession().getAttribute("agent");
        if (agent == null){
            System.out.println("Nije ulogovan");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            System.out.println("Ulogovan " + agent.getUserUsername());
            return new ResponseEntity<>(agent, HttpStatus.OK);
        }
    }
}
