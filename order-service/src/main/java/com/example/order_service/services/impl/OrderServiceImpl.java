package com.example.order_service.services.impl;

import com.example.order_service.commons.models.OrderModelResponse;
import com.example.order_service.repo.OrderItemRepository;
import com.example.order_service.repo.OrderRepository;
import com.example.order_service.repo.entity.Order;
import com.example.order_service.services.OrderService;
import com.example.order_service.services.mappers.OrderMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public List<OrderModelResponse> listCustomerOrders(Long customerId) {

        List<Order> orders = orderRepository.findByCustomerId(customerId);

        log.info("Found {} orders for customer with ID {}", orders.size(), customerId);

        return orders.stream()
                .map(orderMapper::toModel)
                .collect(Collectors.toList());
    }
}
