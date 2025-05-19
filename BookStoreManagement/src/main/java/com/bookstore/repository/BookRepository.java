package com.bookstore.repository;

import com.bookstore.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {

    // Custom search query (you can use @Query if needed)
    @Query("SELECT b FROM Book b WHERE " +
           "(b.title LIKE %?1% OR ?1 IS NULL) AND " +
           "(b.author LIKE %?2% OR ?2 IS NULL) AND " +
           "(b.category.name LIKE %?3% OR ?3 IS NULL)")
    Page<Book> searchBooks(String title, String author, String category, Pageable pageable);
}
