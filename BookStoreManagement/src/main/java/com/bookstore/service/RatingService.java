package com.bookstore.service;

import com.bookstore.entity.Rating;

import java.util.List;

public interface RatingService {
    Rating addRating(Rating rating);
    List<Rating> getRatingsByBook(Long bookId);
    List<Rating> getRatingsByUser(Long userId);
}
