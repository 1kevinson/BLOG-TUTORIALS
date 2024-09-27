package com.example.f_no_class_with_more_than_two_instances_variables;

import java.time.LocalDate;

public class Book {

    private final String title;
    private final Author author;
    private final LocalDate publicationYear;
    private final String isbn;

    public Book(String title, Author author, LocalDate publicationYear, String isbn) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
    }
}

class Author {

    private final String name;
    private final String bio;
    private final String birthDate;

    public Author(String name, String bio, String birthDate) {
        this.name = name;
        this.bio = bio;
        this.birthDate = birthDate;
    }
}
