package com.backend.userservice.userservice.dtos;

import com.backend.userservice.userservice.models.Role;
import com.backend.userservice.userservice.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Setter
@Getter
public class UserDTO {
    private String email;
    private Set<Role> roles;

    public static UserDTO from(User user) {
        return new UserDTO(user.getEmail(), user.getRoles());
    }
}
