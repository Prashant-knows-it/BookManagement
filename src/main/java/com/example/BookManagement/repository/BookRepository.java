package com.example.BookManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BookManagement.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    
    List<Book> findByAuthor_Name(String authorName);
    List<Book> findByGenre(String genre);
    List<Book> findByBookTitleContaining(String titlePart);
    List<Book> findByPublicationYearBetween(int startYear, int endYear);
    List<Book> findByPriceBetween(double minPrice, double maxPrice);
    List<Book> findByStockQuantityGreaterThan(int quantity);
}
