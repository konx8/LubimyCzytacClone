package com.Clone.LubimyCzytacClone.controllers;

import com.Clone.LubimyCzytacClone.DAO.UserDAO;
import com.Clone.LubimyCzytacClone.entity.User;
import com.Clone.LubimyCzytacClone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUser(@RequestParam Long id) {
        User user = userService.getUser(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().build();
        }
    }

    @PostMapping("/user")
    public ResponseEntity<UserDAO> addUser(@RequestBody User newUserData) {
        UserDAO newUser = userService.createUser(newUserData);
        if (newUser == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        }

    }


}
