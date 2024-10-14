package com.example.order_service.services.mappers;

import com.example.order_service.commons.models.OrderModelResponse;
import com.example.order_service.repo.entity.Order;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",uses = {OrderItemMapper.class})
public interface OrderMapper {

    OrderModelResponse toModel(Order order);
}
