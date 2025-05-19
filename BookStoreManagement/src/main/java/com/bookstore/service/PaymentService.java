package com.bookstore.service;

import com.bookstore.entity.Payment;

import java.util.List;

public interface PaymentService {
    Payment makePayment(Payment payment);
    List<Payment> getAllPayments();
    Payment getPaymentById(Long id);
}
