package com.example.pricing_service.services.impl;


import com.example.pricing_service.commons.models.EventModel;
import com.example.pricing_service.commons.models.PricingModel;
import com.example.pricing_service.repo.PricingRepository;
import com.example.pricing_service.repo.entity.Pricing;
import com.example.pricing_service.services.PricingService;
import com.example.pricing_service.services.mapper.PricingMapper;
import com.example.pricing_service.services.mapper.PricingProductMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Transactional
@Service
@Slf4j
@RequiredArgsConstructor
public class PricingServiceImpl implements PricingService {

    private final ObjectMapper objectMapper;
    private final PricingRepository pricingRepository;
    private final PricingProductMapper pricingProductMapper;
    private final PricingMapper pricingMapper;

    @Override
    public void readFromQueueAndSave(String jsonString) {

        EventModel retrievedEventModel = null;

        try {
            retrievedEventModel = objectMapper.readValue(jsonString, EventModel.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Pricing pricing = pricingProductMapper.toPricingEntity(retrievedEventModel.getProductModel());

        System.out.println(pricing);

        pricingRepository.save(pricing);

        System.out.println(pricing);
    }

    @Override
    public void addOrUpdatePricing(PricingModel pricingModel) {

        Pricing pricing = pricingMapper.toEntity(pricingModel);

        Optional<Pricing> existPricing = pricingRepository.findBySkuAndCurrency(pricingModel.getSku(),pricingModel.getCurrency());

        if(existPricing.isPresent())
            pricing.setId(existPricing.get().getId());


        pricingRepository.save(pricing);

        System.out.println(pricing);
    }

    @Override
    public Optional<PricingModel> getPricingForSkuAndDate(String sku, LocalDateTime dateTime) {
        return Optional.ofNullable(pricingMapper.toModel(pricingRepository.findBySkuAndDate(sku, dateTime)));
    }
}
