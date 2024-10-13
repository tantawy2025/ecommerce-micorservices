package com.example.discount_service.services.impl;

import com.example.discount_service.commons.models.DiscountModel;
import com.example.discount_service.repo.DiscountRepository;
import com.example.discount_service.repo.entity.Discount;
import com.example.discount_service.services.DiscountService;
import com.example.discount_service.services.mapper.DiscountMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Transactional
@Slf4j
@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;
    private final DiscountMapper discountMapper;

    @Override
    public DiscountModel findBySku(String sku) {

        Optional<Discount> discount = discountRepository.findBySku(sku);
        return discountMapper.toModel(discount.get());
    }

    @Override
    public DiscountModel createDiscount(DiscountModel discountModel) {

        Discount discount = discountMapper.toEntity(discountModel);
        discount.setCreatedDate(LocalDateTime.now());
        discount.setLastModifiedDate(LocalDateTime.now());

        Discount savedDiscount = discountRepository.save(discount);

        return discountMapper.toModel(savedDiscount);
    }

    @Override
    public Page<DiscountModel> getAll(Pageable pageable) {
        return discountRepository.findAll(pageable).map(discountMapper::toModel);
    }

    @Override
    public void create(DiscountModel discountModel) {
        discountRepository.save(discountMapper.toEntity(discountModel));
        log.info("category added successfully");
    }
}
