package com.example.demo.controller;

import com.example.demo.model.dto.SearchDto;
import com.example.demo.service.ItemService;
import com.example.demo.storage_models.dto.ItemDto;
import com.example.demo.storage_models.entities.ItemEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;


    @RequestMapping(value = "/search", method = {RequestMethod.POST})
    public ResponseEntity<List<ItemEntity>> itemGetAllByName(@RequestBody final SearchDto searchDTO) {
        return ResponseEntity.ok(itemService.findAllByCriteria(searchDTO.getSearchCriteria(), searchDTO.getSearchInput()));
    }

    @ResponseBody
    @GetMapping(value = "/goods")
    public List<ItemEntity> getAll() {
        return itemService.getAll();
    }

    @PreAuthorize("hasAuthority('VIEW_ADMIN')")
    @RequestMapping(value = "/goods/{goodId}", method = RequestMethod.DELETE)
    public ResponseEntity<List<ItemEntity>> ItemDelete(@PathVariable String goodId) {
       itemService.deleteItem(Integer.parseInt(goodId));
        return ResponseEntity.ok(itemService.getAll());
    }

    @PreAuthorize("hasAuthority('VIEW_ADMIN')")
    @RequestMapping(value = "/add-good", method = RequestMethod.POST)
    public ResponseEntity<ItemDto> bookFormControllerPost(@Valid @RequestBody final ItemDto itemModel) {

        ItemEntity itemEntity = itemService.createItem(itemModel.getName(),
                                                        itemModel.getDescription(),  itemModel.getPrice(), itemModel.getQuantity(), itemModel.getCategory());
        ItemDto itemDto = new ItemDto();
        itemDto.setName(itemEntity.getName());
        itemDto.setPrice(itemEntity.getPrice());
        itemDto.setDescription(itemEntity.getDescription());
        itemDto.setQuantity(itemEntity.getQuantity());
        itemDto.setCategory(itemEntity.getCategory());

        return ResponseEntity.ok(itemDto);
    }



}
