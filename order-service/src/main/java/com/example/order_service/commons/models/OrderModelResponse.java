package com.example.order_service.commons.models;

import com.example.order_service.repo.entity.Auditable;
import com.example.order_service.repo.entity.OrderItem;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderModelResponse  {

    private Long customerId;
    private LocalDateTime orderDate;
    private String shippingAddress;
    private BigDecimal totalAmount;
    private String orderStatus;
    private String paymentStatus;
    private String paymentRefNo;
    private List<OrderItemModelResponse> orderItems;
}
