package com.megatravel.agentbackend.service;

import com.megatravel.agentbackend.dto.UserDto;
import com.megatravel.agentbackend.model.User;
import com.megatravel.agentbackend.repository.UserRepository;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AddServiceService addServiceService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    AccTypeService accTypeService;
    @Autowired
    AccommodationService accommodationService;
    @Autowired
    ReservationService reservationService;
    @Autowired
    MessageService messageService;
    @Autowired
    ReviewService reviewService;


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getOneById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User getOneByDbId(Long id) {
        return userRepository.findByUserDbId(id);
    }

    @Override
    public User getOneByUsername(String username) {
        return userRepository.findByUserUsername(username);
    }

    @Override
    public User addOne(User user) {
        return userRepository.save(user);
    }

    @Override
    public User editOne(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean deleteOne(User user) {
        userRepository.delete(user);
        return (userRepository.existsById(user.getUserId())?true:false);
    }

    @Override
    public boolean deleteById(Long id) {
        userRepository.deleteById(id);
        return (userRepository.existsById(id)?true:false);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User logInUser(UserDto userDto) {
        User agent = userRepository.findByUserUsername(userDto.getUserUsername());
        //TODO: zakaciti agenta na sesiju
        if(agent != null && agent.getUserPassword().equals(userDto.getUserPassword())) {
            agent.setUserPassword("");
            return agent;
        }else
            return null;
    }

    @Override
    public void logOut() {
        //TODO: Odjaviti korisnika i pokrenuti sinhronizaciju sa glavnom bazom, ali mozda i nece biti potrebno ako se sinhronizuje u real time-u
        messageService.deleteAll();
        reservationService.deleteAll();
        reviewService.deleteAll();
        accommodationService.deleteAll();

        accTypeService.deleteAll();
        addServiceService.deleteAll();

        categoryService.deleteAll();
        deleteAll();

    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
