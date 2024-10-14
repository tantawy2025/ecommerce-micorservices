package com.example.order_service.commons.models;

import com.example.order_service.repo.entity.Order;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemModelResponse {

    private String sku;
    private int quantity;
    private BigDecimal pricePerUnit;
    private BigDecimal totalPrice;

}
