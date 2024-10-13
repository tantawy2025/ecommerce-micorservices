package com.example.pricing_service.services;


import com.example.pricing_service.commons.models.PricingModel;
import com.example.pricing_service.repo.entity.Pricing;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PricingService {

    void readFromQueueAndSave(String jsonString);


    void addOrUpdatePricing(PricingModel pricingModel);

    Optional<PricingModel> getPricingForSkuAndDate(String sku, LocalDateTime dateTime);
}
