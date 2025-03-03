package com.example.BookManagement.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AuthorResponseDTO {
    private Long authorId;
    private String name;
    private String biography;
    private List<String> bookTitles;
}
