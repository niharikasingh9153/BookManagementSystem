package com.example.BookManagementSys.service;


import com.example.BookManagementSys.model.Book;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BookServiceImpl implements BookService {
    private static final List<Book> books = new ArrayList<>();

    @Override
    public List<Book> getAllBooks() { return books; }

    @Override
    public Optional<Book> getBookById(int id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    @Override
    public Book addBook(Book book) {
        books.add(book);
        return book;
    }

    @Override
    public boolean updateBook(int id, Book updatedBook) {
        Optional<Book> optionalBook = getBookById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setPrice(updatedBook.getPrice());
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteBook(int id) {
        return books.removeIf(book -> book.getId().equals(id));
    }

    @Override
    public List<Book> getBooksByAuthor(String author) {
        return books.stream().filter(book -> book.getAuthor().equalsIgnoreCase(author)).toList();
    }

    @Override
    public List<Book> getBooksCheaperThan(double price) {
        return books.stream().filter(book -> book.getPrice() <= price).toList();
    }

    @Override
    public int getTotalBooks() {
        return books.size();
    }

    @Override
    public Book getMostExpensiveBook() {
        return books.stream()
                .max(Comparator.comparing(Book::getPrice))
                .orElse(null);
    }
}
