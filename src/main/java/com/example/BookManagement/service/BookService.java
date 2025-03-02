package com.example.BookManagement.service;

import com.example.BookManagement.entity.Book;

import java.util.List;

public interface BookService {
    
    Book saveBook(Book book);
    
    Book getBookById(Long id);
    
    List<Book> getAllBooks();
    
    List<Book> getBooksByAuthorName(String authorName);
    
    List<Book> getBooksByGenre(String genre);
    
    List<Book> searchBooksByTitle(String titlePart);
    
    List<Book> getBooksByPublicationYearRange(int startYear, int endYear);
    
    List<Book> getBooksByPriceRange(double minPrice, double maxPrice);
    
    List<Book> getAvailableBooks(int minimumStock);
    
    Book updateBook(Long id, Book book);
    
    void deleteBook(Long id);
}
