package com.bookstore.service;

import com.bookstore.entity.Wishlist;

import java.util.List;

public interface WishlistService {
    Wishlist addToWishlist(Wishlist wishlist);
    List<Wishlist> getWishlistByUser(Long userId);
    void removeFromWishlist(Long id);
}
