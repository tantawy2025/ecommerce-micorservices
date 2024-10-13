package com.example.payment.integration;


import com.example.payment.commons.models.CustomerModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerService {

    @GetMapping("api/v1/customers/{id}")
    ResponseEntity<CustomerModel> getCustomer(@RequestParam Long id);
}
