package com.example.demo.controller;

import com.example.demo.service.CategoryService;
import com.example.demo.storage_models.dto.CategoryDto;
import com.example.demo.storage_models.entities.CategoryEntity;
import com.example.demo.storage_models.entities.ItemEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @ResponseBody
    @GetMapping(value = "/groups")
    public List<CategoryEntity> getAll() {
        return categoryService.getAll();
    }

    @PreAuthorize("hasAuthority('VIEW_ADMIN')")
    @RequestMapping(value = "/groups/{groupId}", method = RequestMethod.DELETE)
    public ResponseEntity<List<CategoryEntity>> ItemDelete(@PathVariable String groupId) {
       categoryService.deleteCategory(Integer.parseInt(groupId));
        return ResponseEntity.ok(categoryService.getAll());
    }

    @PreAuthorize("hasAuthority('VIEW_ADMIN')")
    @RequestMapping(value = "/add-group", method = RequestMethod.POST)
    public ResponseEntity<CategoryDto> bookFormControllerPost(@Valid @RequestBody final CategoryDto categoryModel) {

        CategoryEntity categoryEntity = categoryService.createCategory(categoryModel.getName(), categoryModel.getDescription() );
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(categoryEntity.getName());
        categoryDto.setDescription(categoryEntity.getDescription());

        return ResponseEntity.ok(categoryDto);
    }

}
