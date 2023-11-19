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
    public List<UserDAO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user")
    public ResponseEntity<UserDAO> getUser(@RequestParam Long id) {
        UserDAO user = userService.getUser(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(user);
        }
    }

    @PostMapping("/user")
    public ResponseEntity<UserDAO> createUser(@RequestBody User newUserData) {
        try {
            UserDAO newUser = userService.createUser(newUserData);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(new UserDAO(e.getMessage(), null));
        }
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam Long id){
        userService.deleteUser(id);
    }


}
