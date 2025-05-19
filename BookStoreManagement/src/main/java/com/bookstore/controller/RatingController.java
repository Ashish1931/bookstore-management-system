package com.bookstore.controller;

import com.bookstore.entity.Rating;
import com.bookstore.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public Rating add(@RequestBody Rating rating) {
        return ratingService.addRating(rating);
    }

    @GetMapping("/book/{bookId}")
    public List<Rating> getByBook(@PathVariable Long bookId) {
        return ratingService.getRatingsByBook(bookId);
    }

    @GetMapping("/user/{userId}")
    public List<Rating> getByUser(@PathVariable Long userId) {
        return ratingService.getRatingsByUser(userId);
    }
}
