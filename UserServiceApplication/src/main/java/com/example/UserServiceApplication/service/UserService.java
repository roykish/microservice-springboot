package com.example.UserServiceApplication.service;

import com.example.UserServiceApplication.Entity.Rating;
import com.example.UserServiceApplication.Entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User updateUser(User user);
    List<User> getAllUsers();
    User getSingleUser(String userId);
    User removeUser (long UserId);
    List<Rating> findAllRatingsOfUser(String userId);
}
