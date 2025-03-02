package com.example.BookManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookManagement.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);
} 