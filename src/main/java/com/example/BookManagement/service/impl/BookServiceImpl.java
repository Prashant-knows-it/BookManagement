package com.example.BookManagement.service.impl;

import com.example.BookManagement.dto.BookDTO;
import com.example.BookManagement.entity.Author;
import com.example.BookManagement.entity.Book;
import com.example.BookManagement.repository.AuthorRepository;
import com.example.BookManagement.repository.BookRepository;
import com.example.BookManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Book saveBook(BookDTO bookDTO) {
        Author author = null;
        if (bookDTO.getExistingAuthorId() != null) {
            author = authorRepository.findById(bookDTO.getExistingAuthorId()).orElse(null);
        }
        if (author == null && bookDTO.getNewAuthor() != null) {
            author = authorRepository.save(bookDTO.getNewAuthor());
        }

        if (author == null) {
            throw new IllegalArgumentException("Author information is required.");
        }

        Book book = new Book();
        book.setBookTitle(bookDTO.getBookTitle());
        book.setGenre(bookDTO.getGenre());
        book.setPublicationYear(bookDTO.getPublicationYear());
        book.setPrice(bookDTO.getPrice());
        book.setStockQuantity(bookDTO.getStockQuantity());
        book.setAuthor(author);

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
    public Book updateBook(Long id, BookDTO bookDTO) {
        Book existingBook = bookRepository.findById(id).orElse(null);
        if (existingBook == null) {
            throw new IllegalArgumentException("Book not found.");
        }

        Author author = null;
        if (bookDTO.getExistingAuthorId() != null) {
            author = authorRepository.findById(bookDTO.getExistingAuthorId()).orElse(null);
        }
        if (author == null && bookDTO.getNewAuthor() != null) {
            author = authorRepository.save(bookDTO.getNewAuthor());
        }

        if (author == null) {
            throw new IllegalArgumentException("Author information is required.");
        }

        existingBook.setBookTitle(bookDTO.getBookTitle());
        existingBook.setGenre(bookDTO.getGenre());
        existingBook.setPublicationYear(bookDTO.getPublicationYear());
        existingBook.setPrice(bookDTO.getPrice());
        existingBook.setStockQuantity(bookDTO.getStockQuantity());
        existingBook.setAuthor(author);

        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
