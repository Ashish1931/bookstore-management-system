package com.bookstore.service;

import com.bookstore.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    Book createBook(Book book);
    Book getBookById(Long id);
    List<Book> getAllBooks();
    Book updateBook(Long id, Book book);
    void deleteBook(Long id);

    Page<Book> getAllBooks(Pageable pageable);  // Pagination method
    Page<Book> searchBooks(String title, String author, String category, Pageable pageable);  // Search with pagination
}
