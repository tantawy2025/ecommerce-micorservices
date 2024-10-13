package com.example.payment.services;


public interface PaymentService {


    public boolean verifyBalance(Long customerId, double amount);
}
