package com.example.demo.repository;

import com.example.demo.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    @Query("SELECT u FROM CategoryEntity u WHERE u.name LIKE :name")
    CategoryEntity findByName(@Param("name") String name);
}