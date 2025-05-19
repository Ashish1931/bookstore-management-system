package com.bookstore.repository;

import com.bookstore.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {
    List<Rating> findByBookId(Long bookId);
    List<Rating> findByUserId(Long userId);
}
