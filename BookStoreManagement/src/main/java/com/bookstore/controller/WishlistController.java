package com.bookstore.controller;

import com.bookstore.entity.Wishlist;
import com.bookstore.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @PostMapping
    public Wishlist add(@RequestBody Wishlist wishlist) {
        return wishlistService.addToWishlist(wishlist);
    }

    @GetMapping("/user/{userId}")
    public List<Wishlist> getByUser(@PathVariable Long userId) {
        return wishlistService.getWishlistByUser(userId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        wishlistService.removeFromWishlist(id);
    }
}
