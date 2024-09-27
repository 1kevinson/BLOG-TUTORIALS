package com.example.f_no_class_with_more_than_two_instances_variables;

import java.time.LocalDate;

public class BookRefacto {

    private final String title;
    private final AuthorRefacto author;

    public BookRefacto(String title, AuthorRefacto author) {
        this.title = title;
        this.author = author;
    }
}

class AuthorRefacto {

    private final String name;
    private final String birthDate;

    public AuthorRefacto(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }
}
