package com.example.BookManagement.dto;

import com.example.BookManagement.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Long bookId;
    private String bookTitle;
    private String genre;
    private int publicationYear;
    private double price;
    private int stockQuantity;
    private Long existingAuthorId;
    private Author newAuthor;
    public String getAuthorName() {
        return newAuthor != null ? newAuthor.getName() : null;
    }
    
}