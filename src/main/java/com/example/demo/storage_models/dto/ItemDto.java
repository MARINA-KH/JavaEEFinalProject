package com.example.demo.storage_models.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Setter
@Getter
@ToString
public class ItemDto {
    /*
    * id
    * category id
    * name
    * desc
    * quantity
    * price
    * */

    public int id;

    @NotEmpty(message = "name cannot be empty")
    @Size(min = 2)
    public String name;
    @NotEmpty(message = "description cannot be empty")
    public String description;
    @NotEmpty(message = "quantity cannot be empty")
    public int quantity;
    @NotEmpty(message = "quantity cannot be empty")
    public double price;
}
