package com.example.customer.services.mapper;

import com.example.customer.commons.models.CustomerModel;
import com.example.customer.repo.entity.Customer;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer toEntity(CustomerModel discountModel);

    CustomerModel toModel(Customer discount);
}
