package com.megatravel.mainbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.megatravel.mainbackend.dto.UserDto;
import com.megatravel.mainbackend.model.User;
import com.megatravel.mainbackend.model.UserType;
import com.megatravel.mainbackend.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	//private PasswordEncoder passwordEncoder;
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User deleteUser(Long id) {
		User user = userRepository.getOne(id);
		if(user == null || user.getUserType() != UserType.ENDUSER)
			return null;
		
		user.setDeleted(true);
		user.setActivated(false);
		return userRepository.save(user);
	}

	@Override
	public User findOne(Long id) {
		// TODO Auto-generated method stub
		return userRepository.getOne(id);
	}
	
	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByUserEmail(email);
	}
	
	@Override
	public User convertFromDTO(UserDto userDto) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserFirstName(userDto.getUserFirstName());
		user.setUserLastName(userDto.getUserLastName());
		user.setUserEmail(userDto.getUserEmail());
		user.setUserPassword(userDto.getUserPassword());
		user.setUserUsername(userDto.getUserUsername());
		
		return user;
	}

	@Override
	public User registerNewUserAccount(UserDto userDto){
		// TODO Auto-generated method stub
		 User user = convertFromDTO(userDto);
		 
		 if(emailExists(userDto.getUserEmail())) {
			 System.out.println("Email exist");
			 return null;
		 }
		 
		 user.setActivated(true);
		 user.setDeleted(false);
		 user.setUserType(UserType.ENDUSER);
		 
		 return userRepository.save(user);
	}
	
	private boolean emailExists(String email) {
        User user = userRepository.findByUserEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }

	@Override
	public User signIn(UserDto userDto) {
		// TODO Auto-generated method stub
//		User user1 = new User();
		if(userExist(userDto.getUserEmail(),userDto.getUserPassword())) {
//			firstName,LastName,Email,Username,Password
//			user1 = convertFromDTO(userDto);
			
//			user1.setUserId(findByEmail(userDto.getUserEmail()).getUserId());
//			user1.setUserType(findByEmail(userDto.getUserEmail()).getUserType());
//			user1.setActivated(findByEmail(userDto.getUserEmail()).isActivated());
//			user1.setDeleted(findByEmail(userDto.getUserEmail()).isDeleted());
			return findByEmail(userDto.getUserEmail());
		}
		return null;
	}

	private boolean userExist(String userEmail, String userPassword) {
		// TODO Auto-generated method stub
		User user=userRepository.findByUserEmailAndUserPassword(userEmail, userPassword);
		if(user!=null){
			System.out.println("Odgovaraju email i sifra");
            return true;
		}
		 System.out.println("Ne odgovaraju email i sifra");
	        return false;
	}

	@Override
	public User blockActivateUser(Long id, boolean activated) {
		User user = userRepository.getOne(id);
		if(user == null || user.getUserType() != UserType.ENDUSER || user.isDeleted() == true)
			return null;
		
		user.setActivated(activated);
		return userRepository.save(user);
	}

	@Override
	public void registerAgent(User agent) {
		agent.setActivated(true);
		agent.setUserType(UserType.AGENT);
		agent.setDeleted(false);
		userRepository.save(agent);
	}

	


}
