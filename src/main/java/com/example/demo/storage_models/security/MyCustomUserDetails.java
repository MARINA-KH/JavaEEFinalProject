package com.example.demo.model.security;

import com.example.demo.model.BookEntity;
import lombok.Getter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;
import java.util.Set;

@Getter
@ToString(callSuper = true)
public class MyCustomUserDetails extends User {

    private final String email;

    public MyCustomUserDetails(
            final String username,
            final String password,
            final List<? extends GrantedAuthority> authorities,
            final String email) {
        super(username, password, authorities);
        this.email = email;
    }
}