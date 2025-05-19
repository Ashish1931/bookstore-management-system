package com.bookstore.service.impl;

import com.bookstore.entity.ShippingAddress;
import com.bookstore.repository.ShippingAddressRepository;
import com.bookstore.service.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {

    @Autowired
    private ShippingAddressRepository addressRepository;

    @Override
    public ShippingAddress saveAddress(ShippingAddress address) {
        return addressRepository.save(address);
    }

    @Override
    public List<ShippingAddress> getAddressesByUser(Long userId) {
        return addressRepository.findByUserId(userId);
    }

    @Override
    public void deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
    }
}
