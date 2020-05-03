package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import com.example.demo.storage_models.entities.PermissionEntity;
import com.example.demo.storage_models.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    @Transactional
    public UserEntity registerUser(final String username, final String password, final String email, final List<PermissionEntity> permissions) {
        System.out.println("Register user");

        final UserEntity user = new UserEntity();
        user.setName(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPermissions(permissions);
        System.out.println("Added user");
        System.out.println(user.getName() + ", " + user.getEmail());
        return userRepository.saveAndFlush(user);
    }





}
