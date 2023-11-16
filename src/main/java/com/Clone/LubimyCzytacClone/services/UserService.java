package com.Clone.LubimyCzytacClone.services;

import com.Clone.LubimyCzytacClone.DAO.UserDAO;
import com.Clone.LubimyCzytacClone.entity.User;
import com.Clone.LubimyCzytacClone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(Long id){
        User userById = userRepository.getUserById(id);
        if (userById == null){
            return null;
        }else {
            return userRepository.getUserById(id);
        }
    }
    public UserDAO createUser(User newUser){

        User checkNewUserData = userRepository.getUserByLoginAndEmail(newUser.getLogin(), newUser.getEmail());
        if (checkNewUserData == null){
            userRepository.save(newUser);
            return new UserDAO(newUser.getLogin(),
                    newUser.getEmail());
        } else {
            return null;
        }

    }



}
