package com.megatravel.mainbackend.service;
import com.megatravel.mainbackend.model.User;

import java.util.List;


public interface UserService {

	List<User> getAllUsers();
	User save(User user);
	void deleteUser(Long id);
	
	User findOne(Long id);
	User getUser();
	User updateUser(User user);
	
	
	
}
