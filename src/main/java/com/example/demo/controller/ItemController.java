package com.example.demo.controller;

import com.example.demo.model.ItemEntity;
import com.example.demo.model.dto.ItemDto;
import com.example.demo.model.dto.SearchDto;
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
    public List<ItemEntity> itemGet() {
        return itemService.findAllItems();
    }

    @PreAuthorize("hasAuthority('VIEW_ADMIN')")
    @RequestMapping(value = "/goods/{goodId}", method = RequestMethod.DELETE)
    public ResponseEntity<Set<ItemEntity>> ItemDelete(@PathVariable String goodId) {
        Set<ItemEntity> items = itemService.deleteItem(Integer.parseInt(goodId));
        return ResponseEntity.ok(items);
    }

    @PreAuthorize("hasAuthority('VIEW_ADMIN')")
    @RequestMapping(value = "/add-good", method = RequestMethod.POST)
    public ResponseEntity<ItemDto> bookFormControllerPost(@Valid @RequestBody final ItemDto itemModel) {

        ItemEntity itemEntity = itemService.createItem(itemModel.getName(), itemModel.getManufacturer(), itemModel.getPrice(),
                                                        itemModel.getDescription(), itemModel.getQuantity(), itemModel.getCategory());
        ItemDto itemDto = new ItemDto();
        itemDto.setName(item.getAuthor());
        itemDto.setManufacturer(itemEntity.getManufacturer());
        itemDto.setPrice(itemEntity.getPrice());
        itemDto.setDescription(itemEntity.getDescription());
        itemDto.setQuantity(itemEntity.getQuantity());
        itemDto.setCategory(itemEntity.getCategory());

        return ResponseEntity.ok(itemDto);
    }



}
