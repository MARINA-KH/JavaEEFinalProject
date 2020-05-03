package com.example.demo.storage_models.entities;

import com.example.demo.storage_models.UserGroup;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class UserEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name ="name", unique = true)
    public String name;

    @Column(name ="email", unique = true)
    public String email;

    @Column(name = "password")
    public String password;

    @ManyToMany
    @JoinTable(
            name="user_to_permissions",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="group_id")
    )
    private List<UserGroup> group;

}
