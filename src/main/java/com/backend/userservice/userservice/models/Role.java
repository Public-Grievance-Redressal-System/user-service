package com.backend.userservice.userservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "roles")
@Getter
@Setter
public class Role extends BaseModel{
    @Column(unique = true)
    private String role;
}
