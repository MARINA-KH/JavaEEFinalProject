package com.example.demo.repository;

import com.example.demo.storage_models.entities.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
    @Query("SELECT u FROM ItemEntity u WHERE u.category.name LIKE :param1")
    List<ItemEntity> findAllByCategory(@Param("param1") int param1);

    @Query("SELECT u FROM ItemEntity u WHERE u.name LIKE :param1")
    List<ItemEntity> findAllByName(@Param("param1") String param1);

    @Query("SELECT u FROM ItemEntity u WHERE u.price = :param1")
    List<ItemEntity> findAllByPrice(@Param("param1") double param1);
}