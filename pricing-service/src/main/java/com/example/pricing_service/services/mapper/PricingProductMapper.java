package com.example.pricing_service.services.mapper;


import com.example.pricing_service.commons.models.PricingModel;
import com.example.pricing_service.commons.models.ProductModel;
import com.example.pricing_service.repo.entity.Pricing;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PricingProductMapper {
    @Mappings({
        @Mapping(target = "sku", source = "sku"),
        @Mapping(target = "amount", source = "price"),
        @Mapping(target = "startDate", expression = "java(java.time.LocalDateTime.now())"),
        @Mapping(target = "endDate", expression = "java(java.time.LocalDateTime.now().plusDays(30))")
    })
    Pricing toPricingEntity(ProductModel productModel);

    @Mappings({
        @Mapping(target = "sku", source = "sku"),
        @Mapping(target = "amount", source = "amount"),
        @Mapping(target = "currency", source = "currency"),
        @Mapping(target = "startDate", source = "startDate"),
        @Mapping(target = "endDate", source = "endDate")
    })
    PricingModel toPricingModel(Pricing pricing);
}
