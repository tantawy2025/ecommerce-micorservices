package com.example.catalog.services;

import com.example.catalog.commons.models.ProductModel;
import com.example.catalog.repo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface ProductService {

    public void create(ProductModel productModel);

    Page<ProductModel> getAll(Pageable pageable);

    ProductModel findById(Long id);


    ProductModel update(Long id, ProductModel productModel);

    void delete(Long id);


}
