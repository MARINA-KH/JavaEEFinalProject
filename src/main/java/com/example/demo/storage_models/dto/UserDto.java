package com.example.demo.storage_models.dto;

import com.example.demo.storage_models.UserGroup;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@ToString
public class UserDto {

    public int id;

    @NotEmpty(message = "name can`t be empty")
    public String name;

    @NotEmpty(message = "email can`t be empty")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "wrong format")
    public String email;

    @NotEmpty(message = "password cannot be empty")
    @Pattern(regexp = "^(?=.{8,20}$)[a-zA-Z0-9._]+(?<![_.])$", message = "Wrong password format")
    private String password;
}
