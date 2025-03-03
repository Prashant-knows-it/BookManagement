package com.example.BookManagement.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookManagement.dto.AuthorResponseDTO;
import com.example.BookManagement.entity.Author;
import com.example.BookManagement.entity.Book;
import com.example.BookManagement.repository.AuthorRepository;
import com.example.BookManagement.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Author getAuthorByName(String name) {
        return authorRepository.findByName(name);
    }

    @Override
    public List<AuthorResponseDTO> getAllAuthors() {
        return authorRepository.findAll().stream().map(author ->
                new AuthorResponseDTO(
                        author.getId(),
                        author.getName(),
                        author.getBiography(),
                        author.getBooks().stream().map(Book::getBookTitle).collect(Collectors.toList())
                )
        ).collect(Collectors.toList());
    }

    @Override
    public Author updateAuthor(Long id, Author author) {
        author.setId(id);
        return authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
