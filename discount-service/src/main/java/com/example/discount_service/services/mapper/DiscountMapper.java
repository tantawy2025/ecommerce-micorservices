package com.example.discount_service.services.mapper;

import com.example.discount_service.commons.models.DiscountModel;
import com.example.discount_service.repo.entity.Discount;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface DiscountMapper {

    Discount toEntity(DiscountModel discountModel);

    DiscountModel toModel(Discount discount);
}
