package com.example.demo.repository;

import com.example.demo.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
    @Query("SELECT u FROM ItemEntity u WHERE u.categoryId LIKE :param1")
    List<ItemRepository> findAllByCategory(@Param("param1") int param1);

    @Query("SELECT u FROM ItemEntity u WHERE u.name LIKE :param1")
    List<ItemRepository> findAllByName(@Param("param1") String param1);

    @Query("SELECT u FROM ItemEntity u WHERE u.price LIKE :param1")
    List<ItemRepository> findAllByPrice(@Param("param1") double param1);
}