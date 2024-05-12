package com.dev.Splitwise.Splitwise.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class User extends BaseModel{
    private String email;
    private String name;
    private String password;
    @ManyToMany
    private List<SplitwiseGroup> groups;
    @ManyToMany
    private List<User> friends;
}
