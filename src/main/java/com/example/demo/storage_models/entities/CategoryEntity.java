package com.example.demo.storage_models.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Column(name = "name", unique = true)
    public String name;
    @Column(name = "description", unique = true)
    public String description;

    @OneToMany(mappedBy="category")
    public Set<ItemEntity> items;

}
