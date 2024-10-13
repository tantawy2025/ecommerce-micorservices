package com.example.customer.services;

import com.example.customer.commons.models.CustomerModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {

    CustomerModel findById(Long id);

}
