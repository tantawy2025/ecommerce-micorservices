package com.example.catalog.commons.models;

import com.example.catalog.repo.entity.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductModel {

    private String name;
    private String sku;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private Boolean status = true;
    private Category category;


}
