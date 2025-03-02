package com.example.BookManagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookManagement.entity.Book;
import com.example.BookManagement.repository.BookRepository;
import com.example.BookManagement.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getBooksByAuthorName(String authorName) {
        return bookRepository.findByAuthor_Name(authorName);
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        return bookRepository.findByGenre(genre);
    }

    @Override
    public List<Book> searchBooksByTitle(String titlePart) {
        return bookRepository.findByBookTitleContaining(titlePart);
    }

    @Override
    public List<Book> getBooksByPublicationYearRange(int startYear, int endYear) {
        return bookRepository.findByPublicationYearBetween(startYear, endYear);
    }

    @Override
    public List<Book> getBooksByPriceRange(double minPrice, double maxPrice) {
        return bookRepository.findByPriceBetween(minPrice, maxPrice);
    }

    @Override
    public List<Book> getAvailableBooks(int minimumStock) {
        return bookRepository.findByStockQuantityGreaterThan(minimumStock);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        book.setID(id);
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
