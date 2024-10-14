package com.example.order_service.repo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;


@Entity
@Table(name = "order_items",schema = "order_service")
@Data
public class OrderItem extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id",columnDefinition = "serial")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "sku")
    private String sku;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price_per_unit")
    private BigDecimal pricePerUnit;

    @Column(name = "total_price")
    private BigDecimal totalPrice;



}
