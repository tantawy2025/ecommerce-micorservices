package com.example.order_service.services.mappers;

import com.example.order_service.commons.models.OrderItemModelResponse;
import com.example.order_service.repo.entity.OrderItem;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItemModelResponse toModel(OrderItem orderItem);

}
