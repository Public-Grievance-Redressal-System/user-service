package com.backend.userservice.userservice.models;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "users")
@Data
@JsonDeserialize(as = User.class)
public class User extends BaseModel {
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String phoneNumber;
    private String password;
    private String address;
    @ManyToMany
    private Set<Role> roles = new HashSet<>();
}
