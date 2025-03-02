package com.example.BookManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String bookTitle;
    private String genre;
    private int publicationYear;
    private double price;
    private int stockQuantity;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
}
