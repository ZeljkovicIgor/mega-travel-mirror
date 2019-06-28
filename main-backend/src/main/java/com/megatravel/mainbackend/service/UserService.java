package com.megatravel.mainbackend.service;
import com.megatravel.mainbackend.dto.UserDto;
import com.megatravel.mainbackend.model.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

	List<User> getAllUsers();
	User save(User user);
	User deleteUser(Long id);
	
	User findOne(Long id);
	
	User getUser();
	User updateUser(User user);
	
	User convertFromDTO(UserDto userDto);
	User registerNewUserAccount(UserDto userDto);
	User signIn(UserDto userDto);

	User findByEmail(String email);
	User findByUsername(String username);
	User blockActivateUser(Long id, boolean activated);
	void registerAgent(User agent);


}
