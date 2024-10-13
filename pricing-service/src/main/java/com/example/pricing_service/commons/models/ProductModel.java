package com.example.pricing_service.commons.models;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductModel {

    private String name;
    private String sku;
    private BigDecimal price;
    private String description;
    private Integer stock;
    private Boolean status = true;



}
