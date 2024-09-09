package com.example.d_first_class_collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Book {
    private String title;
    private String author;
    private String isbn;

    // Constructor
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }

    @Override
    public String toString() {
        return title + " by " + author + " (ISBN: " + isbn + ")";
    }
}

// First class collection
class BookCollection {
    private List<Book> bookList;

    // Constructor
    public BookCollection() {
        this.bookList = new ArrayList<>();
    }

    // Method to add a book
    public void addBook(Book book) {
        bookList.add(book);
    }

    // Method to remove a book
    public boolean removeBook(Book book) {
        return bookList.remove(book);
    }

    // Method to get all books
    public List<Book> getAllBooks() {
        return new ArrayList<>(bookList);
    }

    // Method to find a book by title
    public Book findBookByTitle(String title) {
        return bookList.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    // Method to find all books by an author
    public List<Book> findBooksByAuthor(String author) {
        return bookList.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    // Method to get the total number of books
    public int getTotalBooks() {
        return bookList.size();
    }

    // Method to check if a book exists in the collection
    public boolean containsBook(Book book) {
        return bookList.contains(book);
    }

    // Additional utility methods can be added as needed
}