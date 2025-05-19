package com.bookstore.service;

import com.bookstore.entity.Cart;
import com.bookstore.entity.CartItem;

import java.util.List;

public interface CartService {
    Cart getCartByUserId(Long userId);
    Cart addItemToCart(Long userId, Long bookId, int quantity);
    void removeItem(Long cartItemId);
}
