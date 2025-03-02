package com.example.BookManagement.service;

import com.example.BookManagement.entity.User;

import java.util.List;

public interface UserService {
    
    User saveUser(User user);
    
    User getUserById(Long id);
    
    User getUserByUserName(String userName);
    
    List<User> getAllUsers();
    
    User updateUser(Long id, User user);
    
    void deleteUser(Long id);
}
