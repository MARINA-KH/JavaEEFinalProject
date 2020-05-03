package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.storage_models.Permission;
import com.example.demo.storage_models.dto.UserDto;
import com.example.demo.storage_models.entities.PermissionEntity;
import com.example.demo.storage_models.entities.UserEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
/*
    @PreAuthorize("isFullyAuthenticated()")
    @GetMapping("/user-details")
    public ResponseEntity<MyCustomUserDetails> userDetails() {
        final MyCustomUserDetails userDetails = (MyCustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(userDetails);
    }


    @PreAuthorize("isFullyAuthenticated()")
    @GetMapping(value = "/fav-books")
    public ResponseEntity<Set<BookEntity>> userFavBooks() {
        final MyCustomUserDetails userDetails = (MyCustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(userService.getUsersLikedBooks(userDetails.getUsername()));
    }

    @PreAuthorize("isFullyAuthenticated()")
    @RequestMapping(value = "/fav-books/{bookId}", method = RequestMethod.POST)
    public ResponseEntity<Set<BookEntity>> bookFormControllerAdd(@PathVariable String bookId) {
        final MyCustomUserDetails userDetails = (MyCustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = userService.addUsersLikedBooks(userDetails.getUsername(), Integer.parseInt(bookId));
        return ResponseEntity.ok(userEntity.getLikedBooks());
    }

    @PreAuthorize("isFullyAuthenticated()")
    @RequestMapping(value = "/fav-books/{bookId}", method = RequestMethod.DELETE)
    public ResponseEntity<Set<BookEntity>> bookFormControllerDelete(@PathVariable String bookId) {
        final MyCustomUserDetails userDetails = (MyCustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity userEntity = userService.deleteUsersLikedBooks(userDetails.getUsername(), Integer.parseInt(bookId));
        return ResponseEntity.ok(userEntity.getLikedBooks());
    }
*/
    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public ResponseEntity<UserDto> registerUserController(@Valid @RequestBody final UserDto userModel) {
        System.out.println(userModel.getPassword());
        System.out.println("==========================================================================================================================================");
        List<PermissionEntity> permissions = new ArrayList<>();
        permissions.add(new PermissionEntity(1, Permission.VIEW_USER));
        UserEntity userEntity = userService.registerUser(userModel.getName(), userModel.getPassword(), userModel.getEmail(), permissions);
        UserDto userDTO = new UserDto();
        userDTO.setId(userEntity.getId());
        userDTO.setPassword(null);
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setName(userEntity.getName());
        return ResponseEntity.ok(userDTO);
    }
}

