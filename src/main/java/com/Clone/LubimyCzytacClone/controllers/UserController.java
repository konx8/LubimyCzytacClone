package com.Clone.LubimyCzytacClone.controllers;

import com.Clone.LubimyCzytacClone.entity.User;
import com.Clone.LubimyCzytacClone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/user")
    public User getUser(@RequestParam Long id){
        return userService.getUser(id);
    }
    @PostMapping("/user")
    public void addUser(@RequestBody User newUser){
        userService.createUser(newUser);
    }


}
