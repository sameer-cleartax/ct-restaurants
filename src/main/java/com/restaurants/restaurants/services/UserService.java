package com.restaurants.restaurants.services;

import com.restaurants.restaurants.entities.UserEntity;
import com.restaurants.restaurants.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void register(UserEntity user) throws Exception {
        if(checkIfUserExist(user.getEmailId())) {
            throw new Exception("User already exist.");
        }
        userRepository.save(user);
        return;
    }

    public boolean checkIfUserExist(String emailId) {
        return userRepository.findByEmailId(emailId) == null ? false : true;
    }

}
