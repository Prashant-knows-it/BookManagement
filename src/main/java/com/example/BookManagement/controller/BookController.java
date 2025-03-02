package com.example.BookManagement.controller;

import com.example.BookManagement.entity.Book;
import com.example.BookManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/author/{authorName}")
    public List<Book> getBooksByAuthorName(@PathVariable String authorName) {
        return bookService.getBooksByAuthorName(authorName);
    }

    @GetMapping("/genre/{genre}")
    public List<Book> getBooksByGenre(@PathVariable String genre) {
        return bookService.getBooksByGenre(genre);
    }

    @GetMapping("/search")
    public List<Book> searchBooksByTitle(@RequestParam String title) {
        return bookService.searchBooksByTitle(title);
    }

    @GetMapping("/year")
    public List<Book> getBooksByPublicationYearRange(@RequestParam int startYear, @RequestParam int endYear) {
        return bookService.getBooksByPublicationYearRange(startYear, endYear);
    }

    @GetMapping("/price")
    public List<Book> getBooksByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
        return bookService.getBooksByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/available")
    public List<Book> getAvailableBooks(@RequestParam int minimumStock) {
        return bookService.getAvailableBooks(minimumStock);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
