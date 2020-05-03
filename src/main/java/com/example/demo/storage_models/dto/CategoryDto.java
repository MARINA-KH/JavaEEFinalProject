package com.example.demo.storage_models.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class CategoryDto {

    public int id;

    @NotEmpty(message = "category name cannot be empty")
    @Size(min = 4)
    public String name;

    @NotEmpty(message = "description cannot be empty")
    public String description;
}
