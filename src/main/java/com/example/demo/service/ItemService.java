package com.example.demo.service;

import com.example.demo.model.BookEntity;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepo;

    @Transactional
    public ItemEntity createItem(String name, String description, double price, int quantity, int category){
        ItemEntity item = new ItemEntity();
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);
        item.setQuantity(quantity);
        item.setCategory(category);

        return itemRepo.saveAndFush(item);
    }

    @Transactional
    public ItemEntity getByCategory(int category){
        Optional<ItemEntity> items = itemRepo.findAllByCategory(category);
        return items.orElse(null);
    }

    @Transactional
    public ItemEntity getAll(){
        return itemRepo.findAll();
    }

    @Transactional
    public ItemEntity getByName(String name){
        Optional<ItemEntity> items = itemRepo.findAllByName(name);
        return items.orElse(null);
    }

    @Transactional
    public ItemEntity getByPrice(double price){
        Optional<ItemEntity> items = itemRepo.findAllByPrice(price);
        return items.orElse(null);
    }

}