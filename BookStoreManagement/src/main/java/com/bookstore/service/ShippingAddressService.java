package com.bookstore.service;

import com.bookstore.entity.ShippingAddress;

import java.util.List;

public interface ShippingAddressService {
    ShippingAddress saveAddress(ShippingAddress address);
    List<ShippingAddress> getAddressesByUser(Long userId);
    void deleteAddress(Long addressId);
}
