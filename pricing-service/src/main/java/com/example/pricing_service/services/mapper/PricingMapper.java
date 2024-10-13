package com.example.pricing_service.services.mapper;

import com.example.pricing_service.commons.models.PricingModel;
import com.example.pricing_service.repo.entity.Pricing;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PricingMapper {

    Pricing toEntity(PricingModel pricingModel);

    PricingModel toModel(Pricing pricing);
}
