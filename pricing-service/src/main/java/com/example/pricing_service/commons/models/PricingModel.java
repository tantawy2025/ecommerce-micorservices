package com.example.pricing_service.commons.models;

import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class PricingModel {

    private String sku;
    private BigDecimal amount;
    private String currency;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
