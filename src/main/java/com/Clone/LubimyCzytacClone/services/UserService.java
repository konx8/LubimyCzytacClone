package com.Clone.LubimyCzytacClone.services;

import com.Clone.LubimyCzytacClone.DAO.UserDAO;
import com.Clone.LubimyCzytacClone.entity.User;
import com.Clone.LubimyCzytacClone.repository.UserRepository;
import com.Clone.LubimyCzytacClone.validator.CreateUserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    CreateUserValidator createUserValidator;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<UserDAO> getUsers(){
        return userRepository.findAll().stream().map(user -> new UserDAO(user.getLogin(), user.getEmail())).toList();
    }

    public UserDAO getUser(Long id){
        User userById = userRepository.getUserById(id);
        if (userById == null){
            return null;
        }else {
            return new UserDAO(userById.getLogin(), userById.getEmail());
        }
    }
    public UserDAO createUser(User newUser){

        createUserValidator.validateEmail(newUser);
        createUserValidator.validatePassword(newUser);
        User getUser = userRepository.getUserByLoginAndEmail(newUser.getLogin(), newUser.getEmail());
        createUserValidator.validateLogin(getUser);
        userRepository.save(newUser);

        return new UserDAO(newUser.getLogin(), newUser.getEmail());
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }



}
