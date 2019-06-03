package com.megatravel.mainbackend.service;
import com.megatravel.mainbackend.model.User;

import java.util.List;

public interface UserService {

	List<User> getAllUsers();
	User getUser();
	User addUser(User user);
	User updateUser(User user);
	void deleteUser(User user);
}
