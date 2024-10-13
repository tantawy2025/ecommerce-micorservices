package com.example.catalog.services.impl;

import com.example.catalog.commons.exceptions.AlreadyExistsException;
import com.example.catalog.commons.exceptions.NotFoundException;
import com.example.catalog.commons.models.EventModel;
import com.example.catalog.commons.models.ProductModel;
import com.example.catalog.repo.ProductRepository;
import com.example.catalog.repo.entity.Product;
import com.example.catalog.services.ProductService;
import com.example.catalog.services.mapper.ProductMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Transactional
@Service
@Slf4j
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepo;
    private final ProductMapper productMapper;
    private final ApplicationEventPublisher applicationEventPublisher;


    @Override
    public void create(ProductModel productModel) {

        log.info("add  product ");
        validateProductExistance(productModel.getName());
        validateProductExistanceBYSKU(productModel.getSku());


        productRepo.save(productMapper.toEntity(productModel));
        log.info("product added successfully");

        // can not rollback from queue, so i made event handler for stop publishing on queue if error occures
        publishEvent(productModel);

    }

    private void publishEvent(ProductModel productModel) {

        EventModel eventModel = new EventModel();
        eventModel.setProductModel(productModel);
        eventModel.setEventType("CREATE_ORDER");

        applicationEventPublisher.publishEvent(eventModel);
    }

    @Override
    public Page<ProductModel> getAll(Pageable pageable) {
        Page<Product> productPage = productRepo.findAll(pageable);
        return productPage.map(productMapper::toModel);
    }

    @Override
    public ProductModel findById(Long id) {
        Product product = productRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Product with ID " + id + " not found"));

        return productMapper.toModel(product);
    }

    @Override
    public ProductModel update(Long id, ProductModel productModel) {
        log.info("update product by id {}",id);
        Product existingProduct =productRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("product with ID " + id + " not found"));

        // check duplicate name when updating the email
        if (!productModel.getName().isEmpty())
            validateProductExistance(productModel.getName());

        validateProductExistanceBYSKU(productModel.getSku());

        Product updatedProduct = productMapper.toEntity(productModel);
        updatedProduct.setId(existingProduct.getId());

        productRepo.save(updatedProduct);
        log.info("product updated successfully ");

        return productMapper.toModel(existingProduct);
    }

    @Override
    public void delete(Long id) {
        log.info("product merchant by id");
        Boolean exist = productRepo.existsById(id);

        if(exist)
            productRepo.deleteById(id);
        else
            throw new NotFoundException("product with ID " + id + " not found");

        log.info("product deleted successfully ");
    }




    private void validateProductExistance(String name) {
        if (productRepo.findByName(name).isPresent()) {
            throw new AlreadyExistsException("Product name " + name + " already exists");
        }
    }

    private void validateProductExistanceBYSKU(String SKU) {
        if (productRepo.findBySku(SKU).isPresent()) {
            throw new AlreadyExistsException("Product SKU " + SKU + " already exists");
        }
    }


}
