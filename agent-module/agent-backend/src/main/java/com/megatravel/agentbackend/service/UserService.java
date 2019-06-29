package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.dto.UserDto;
import com.megatravel.agentbackend.model.User;

import javax.jws.soap.SOAPBinding;
import java.util.List;

public interface UserService {

    List<User> getAll();
    User getOneById(Long id);
    User getOneByDbId(Long id);
    User getOneByUsername(String username);
    User addOne(User user);
    User editOne(User user);
    boolean deleteOne(User  user);
    boolean deleteById(Long id);
    //convertFromDto();
    //convertToDto();

    List<User> getAllUsers();
    User addUser(User user);
    User logInUser(UserDto userDto);
    void logOut();
    void deleteAll();

}
