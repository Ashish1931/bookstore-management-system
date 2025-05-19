package com.bookstore.controller;

import com.bookstore.entity.ShippingAddress;
import com.bookstore.service.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class ShippingAddressController {

    @Autowired
    private ShippingAddressService addressService;

    @PostMapping
    public ShippingAddress save(@RequestBody ShippingAddress address) {
        return addressService.saveAddress(address);
    }

    @GetMapping("/user/{userId}")
    public List<ShippingAddress> getByUser(@PathVariable Long userId) {
        return addressService.getAddressesByUser(userId);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        addressService.deleteAddress(id);
    }
}
