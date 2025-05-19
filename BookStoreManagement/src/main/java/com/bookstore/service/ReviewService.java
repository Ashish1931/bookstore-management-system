package com.bookstore.service;

import com.bookstore.entity.Review;

import java.util.List;

public interface ReviewService {
    Review addReview(Long userId, Long bookId, int rating, String comment);
    List<Review> getReviewsByBookId(Long bookId);
    void deleteReview(Long reviewId);
}
