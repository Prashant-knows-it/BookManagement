package com.example.BookManagement.service;

import com.example.BookManagement.dto.AuthorResponseDTO;
import com.example.BookManagement.entity.Author;

import java.util.List;

public interface AuthorService {
    
    Author saveAuthor(Author author);
    
    Author getAuthorById(Long id);
    
    Author getAuthorByName(String name);
    
    //List<Author> getAllAuthors();
    List<AuthorResponseDTO> getAllAuthors();

    
    Author updateAuthor(Long id, Author author);
    
    void deleteAuthor(Long id);
}
