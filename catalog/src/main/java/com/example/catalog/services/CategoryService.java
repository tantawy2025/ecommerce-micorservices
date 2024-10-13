package com.example.catalog.services;

import com.example.catalog.commons.models.CategoryModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

 public interface CategoryService {

     void create(CategoryModel categoryModel);

     Page<CategoryModel> getAll(Pageable pageable);

     CategoryModel findById(Long id);

     CategoryModel update(Long id, CategoryModel merchantModel);

     void delete(Long id);

}
