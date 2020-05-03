package com.example.demo.storage_models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    @Column(name = "name", unique = true)
    public String name;
    @Column(name = "description")
    public String description;
    @Column(name = "quantity")
    public int quantity;
    @Column(name = "price")
    public double price;

    @Column(name = "category_id")
    @ManyToOne
    @JoinTable(
            name="item_to_category",
            joinColumns = @JoinColumn(name="item_id"),
            inverseJoinColumns = @JoinColumn(name="category_id")
    )
    public int category_id;


}
