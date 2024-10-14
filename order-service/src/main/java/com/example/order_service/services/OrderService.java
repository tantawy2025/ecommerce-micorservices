package com.example.order_service.services;

import com.example.order_service.commons.models.OrderModelResponse;

import java.util.List;

public interface OrderService {


    List<OrderModelResponse> listCustomerOrders(Long customerId);
}
