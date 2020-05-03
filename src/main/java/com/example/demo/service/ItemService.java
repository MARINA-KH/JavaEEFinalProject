package com.example.demo.service;


import com.example.demo.repository.ItemRepository;
import com.example.demo.storage_models.entities.CategoryEntity;
import com.example.demo.storage_models.entities.ItemEntity;
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
    public ItemEntity createItem(String name, String description, double price, int quantity, CategoryEntity category){
        ItemEntity item = new ItemEntity();
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);
        item.setQuantity(quantity);
        item.setCategory(category);

        return itemRepo.saveAndFlush(item);
    }

    @Transactional
    public List<ItemEntity> getByCategory(int category){
        List<ItemEntity> items = itemRepo.findAllByCategory(category);
        return items;
    }

    @Transactional
    public List<ItemEntity> getAll(){
        return itemRepo.findAll();
    }

    @Transactional
    public  List<ItemEntity>  getByName(String name){
        List<ItemEntity> items = itemRepo.findAllByName(name);
        return items;
    }

    @Transactional
    public  List<ItemEntity>  getByPrice(double price){
        List<ItemEntity> items = itemRepo.findAllByPrice(price);
        return items;
    }

    @Transactional
    public void deleteItem(int id) {
        itemRepo.deleteById(id);
    }

    @Transactional
    public List<ItemEntity> findAllByCriteria(String criteria, String searchWord) {
        switch (criteria) {
            case "name":
                return getByName(searchWord);
            case "price":
                return getByPrice(Double.parseDouble(searchWord));
            default:
                return getAll();
        }
    }


}