package com.example.BookManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookManagement.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    
    Author findByName(String name);
}
