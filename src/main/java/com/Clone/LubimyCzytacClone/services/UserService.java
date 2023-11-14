package com.Clone.LubimyCzytacClone.services;

import com.Clone.LubimyCzytacClone.entity.User;
import com.Clone.LubimyCzytacClone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(Long id){
        return userRepository.getUserById(id);
    }
    public void createUser(User newUser){

        //TODO check input data, if user already exist
        userRepository.save(newUser);
    }



}
