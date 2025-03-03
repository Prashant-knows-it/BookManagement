package com.example.BookManagement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BookResponseDTO {
    private Long id;
    private String bookTitle;
    private String genre;
    private int publicationYear;
    private double price;
    private int stockQuantity;
    private String authorName;
}
