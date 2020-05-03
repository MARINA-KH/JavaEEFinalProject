package com.example.demo.service;

import com.example.demo.model.BookEntity;
import com.example.demo.repository.BookRepository;
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
        Optional<CategoryEntity> categories = categoryRepo.findByName(name);
        return categories.orElse(null);
    }

    @Transactional
    public CategoryEntity getAll(){
        return categoryRepo.findAll();
    }
}