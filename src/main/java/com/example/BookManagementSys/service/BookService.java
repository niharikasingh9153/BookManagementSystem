package com.example.BookManagementSys.service;

import com.example.BookManagementSys.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBooks();
    Optional<Book> getBookById(int id);
    Book addBook(Book book);
    boolean updateBook(int id, Book book);
    boolean deleteBook(int id);
    List<Book> getBooksByAuthor(String author);
    List<Book> getBooksCheaperThan(double price);
    int getTotalBooks();
    Book getMostExpensiveBook();
}
