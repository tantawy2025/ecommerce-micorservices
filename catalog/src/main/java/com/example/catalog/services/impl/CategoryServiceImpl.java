package com.example.catalog.services.impl;

import com.example.catalog.commons.exceptions.AlreadyExistsException;
import com.example.catalog.commons.exceptions.NotFoundException;
import com.example.catalog.commons.models.CategoryModel;
import com.example.catalog.repo.CategoryRepository;
import com.example.catalog.repo.entity.Category;
import com.example.catalog.services.CategoryService;
import com.example.catalog.services.mapper.CategoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepo;

    private final CategoryMapper categoryMapper;

    @Override
    public void create(CategoryModel categoryModel) {
        log.info("add  category ");
        validateCategoryExistance(categoryModel.getName());

        categoryRepo.save(categoryMapper.toEntity(categoryModel));
        log.info("category added successfully");
    }

    @Override
    public Page<CategoryModel> getAll(Pageable pageable) {
        return categoryRepo.findAll(pageable).map(categoryMapper::toModel);
    }

    @Override
    public CategoryModel findById(Long id) {
        return categoryRepo.findById(id)
                .map(categoryMapper::toModel)
                .orElseThrow(() -> new NotFoundException("Category with ID " + id + " not found"));
    }

    @Override
    public CategoryModel update(Long id, CategoryModel categoryModel) {
        log.info("update Category by id {}",id);
        Category existingCategory = categoryRepo.findById(id).orElseThrow(() -> new NotFoundException("Category with ID " + id + " not found"));

        // check duplicate category name after update
        if (!categoryModel.getName().isEmpty())
            validateCategoryExistance(categoryModel.getName());

        Category updatedCategory = categoryMapper.toEntity(categoryModel);
        updatedCategory.setId(existingCategory.getId());

        categoryRepo.save(updatedCategory);
        log.info("Category updated successfully ");

        return categoryMapper.toModel(updatedCategory);
    }

    @Override
    public void delete(Long id) {
        log.info("Category merchant by id");
        boolean exist = categoryRepo.existsById(id);

        if(exist)
            categoryRepo.deleteById(id);
        else
            throw new NotFoundException("Category with ID " + id + " not found");

        log.info("Category deleted successfully ");
    }


    private void validateCategoryExistance(String name) {
        if (categoryRepo.findByName(name).isPresent()) {
            throw new AlreadyExistsException("Category name " + name + " already exists");
        }
    }
}
