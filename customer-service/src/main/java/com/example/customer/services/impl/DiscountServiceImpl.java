package com.example.customer.services.impl;

import com.example.customer.commons.models.CustomerModel;
import com.example.customer.repo.CustomerRepository;
import com.example.customer.repo.entity.Customer;
import com.example.customer.services.CustomerService;
import com.example.customer.services.mapper.CustomerMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Transactional
@Slf4j
@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerModel findById(Long id) {

        Optional<Customer> customer = customerRepository.findById(id);
        return customerMapper.toModel(customer.get());
    }

}
