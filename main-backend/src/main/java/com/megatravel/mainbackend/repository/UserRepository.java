package com.megatravel.mainbackend.repository;

import com.megatravel.mainbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUserUsername(String userUsername);
	User findByUserEmail(String userEmail);
	User findByUserEmailAndUserPassword(String userEmail, String userPassword);
	
	
}
