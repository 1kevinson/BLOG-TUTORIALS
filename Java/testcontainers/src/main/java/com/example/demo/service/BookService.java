package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    public final BookRepository repository;

    public Book saveBook(Book book) {
        return this.repository.save(book);
    }

    public List<Book> getBooks() {
        return this.repository.findAll();
    }
}
