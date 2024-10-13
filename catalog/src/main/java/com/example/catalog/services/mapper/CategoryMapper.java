package com.example.catalog.services.mapper;


import com.example.catalog.commons.models.CategoryModel;
import com.example.catalog.repo.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "description", source = "description") // Ensure this mapping if applicable

    })
    Category toEntity(CategoryModel categoryModel);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description") // Ensure this mapping if applicable
    CategoryModel toModel(Category category);
}
