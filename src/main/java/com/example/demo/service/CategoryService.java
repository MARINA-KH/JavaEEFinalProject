package com.example.demo.service;

import com.example.demo.repository.CategoryRepository;
import com.example.demo.storage_models.entities.CategoryEntity;
import com.example.demo.storage_models.entities.ItemEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepo;

    @Transactional
    public CategoryEntity createCategory(String name, String description){
        CategoryEntity category = new CategoryEntity();

        category.setName(name);
        category.setDescription(name);
        return categoryRepo.saveAndFlush(category);
    }

    @Transactional
    public CategoryEntity getByName(String name){
        CategoryEntity category = categoryRepo.findByName(name);
        return category;
    }

    @Transactional
    public void deleteCategory(int id) {
        categoryRepo.deleteById(id);
    }

    @Transactional
    public List<CategoryEntity> getAll(){
        return categoryRepo.findAll();
    }
}