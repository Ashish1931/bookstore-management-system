package com.bookstore.service.impl;

import com.bookstore.entity.Rating;
import com.bookstore.repository.RatingRepository;
import com.bookstore.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatingsByBook(Long bookId) {
        return ratingRepository.findByBookId(bookId);
    }

    @Override
    public List<Rating> getRatingsByUser(Long userId) {
        return ratingRepository.findByUserId(userId);
    }
}
