package com.example.demo.controller;

import com.example.demo.model.CategoryEntity;
import com.example.demo.model.dto.CategoryDto;
import com.example.demo.model.dto.SearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @ResponseBody
    @GetMapping(value = "/groups")
    public List<CategoryEntity> itemGet() {
        return categoryService.findAllCategories();
    }

    @PreAuthorize("hasAuthority('VIEW_ADMIN')")
    @RequestMapping(value = "/groups/{groupId}", method = RequestMethod.DELETE)
    public ResponseEntity<Set<CategoryEntity>> ItemDelete(@PathVariable String groupId) {
        Set<CategoryEntity> categories = categoryService.deleteCategory(Integer.parseInt(groupId));
        return ResponseEntity.ok(categories);
    }

    @PreAuthorize("hasAuthority('VIEW_ADMIN')")
    @RequestMapping(value = "/add-group", method = RequestMethod.POST)
    public ResponseEntity<CategoryDto> bookFormControllerPost(@Valid @RequestBody final CategoryDto categoryModel) {

        CategoryEntity itemEntity = categoryService.createCategory(categoryModel.getName(), categoryModel.getDescription(), categoryModel.getItems());
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(item.getAuthor());
        categoryDto.setDescription(itemEntity.getDescription());
        categoryDto.setCategory(itemEntity.getItems());

        return ResponseEntity.ok(categoryDto);
    }

}
