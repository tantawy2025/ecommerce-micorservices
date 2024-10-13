package com.example.payment.services.impl;


import com.example.payment.commons.models.CustomerModel;
import com.example.payment.integration.CustomerService;
import com.example.payment.services.PaymentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Transactional
@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {


    private final CustomerService customerService;

    @Override
    public boolean verifyBalance(Long customerId, double amount) {
        CustomerModel customerModel = customerService.getCustomer(customerId).getBody();
        if(customerModel.getBalance() > amount)
            return true;
        return false;
    }
}
