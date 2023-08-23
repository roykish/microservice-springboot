package com.example.UserServiceApplication.controller;

import com.example.UserServiceApplication.Entity.User;
import com.example.UserServiceApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
       User savedUser = userService.saveUser(user);
       return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/findUser/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId){
        User fetchedUser = userService.getSingleUser(userId);
        return ResponseEntity.ok(fetchedUser);
    }

    @GetMapping("/findUser/all")
    public ResponseEntity<List<User>> getAllUsers (){
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
