package com.example.catalog.services.mapper;


import com.example.catalog.commons.models.ProductModel;
import com.example.catalog.repo.entity.Product;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring",uses = {CategoryMapper.class})
public interface  ProductMapper {

    Product toEntity(ProductModel productModel);

    ProductModel toModel(Product product);
}
