package com.megatravel.mainbackend.service;
import java.util.List;

import com.megatravel.mainbackend.model.User;

public interface UserService {

	List<User> getAllUsers();
	User getUser();
	User addUser(User user);
	User updateUser(User user);
	void deleteUser(User user);
}
