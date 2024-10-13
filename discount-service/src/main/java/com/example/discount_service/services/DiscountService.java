package com.example.discount_service.services;

import com.example.discount_service.commons.models.DiscountModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DiscountService {

    DiscountModel findBySku(String sku);

    DiscountModel createDiscount(DiscountModel discountModel);

    Page<DiscountModel> getAll(Pageable pageable);

    void create(DiscountModel discountModel);
}
