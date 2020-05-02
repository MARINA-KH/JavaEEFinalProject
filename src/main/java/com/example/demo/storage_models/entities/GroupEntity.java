package com.example.demo.storage_models.entities;

import com.example.demo.model.type.Permission;
import com.example.demo.storage_models.UserGroup;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "groups")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    @Enumerated(EnumType.STRING)
    @Column(name = "group", unique = true)
    private UserGroup group;
}
