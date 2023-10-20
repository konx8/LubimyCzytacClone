package com.Clone.LubimyCzytacClone.services;

import com.Clone.LubimyCzytacClone.entity.User;
import com.Clone.LubimyCzytacClone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User newUser){
        userRepository.save(newUser);
    }



}
